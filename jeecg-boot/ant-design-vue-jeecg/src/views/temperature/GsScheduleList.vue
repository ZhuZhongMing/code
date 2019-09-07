<template>
  <a-card :bordered="false">

    <!-- 查询区域 -->
    <!--<div class="table-page-search-wrapper">
      <a-form layout="inline">
        <a-row :gutter="24">

          <a-col :md="6" :sm="8">
            <a-form-item label="材料批次编码">
              <a-input placeholder="请输入材料批次编码" v-model="queryParam.batchid"></a-input>
            </a-form-item>
          </a-col>
          <a-col :md="6" :sm="8">
            <a-form-item label="结束时间">
              <a-input placeholder="请输入结束时间" v-model="queryParam.endtime"></a-input>
            </a-form-item>
          </a-col>
        <template v-if="toggleSearchStatus">
        <a-col :md="6" :sm="8">
            <a-form-item label="工序编号">
              <a-input placeholder="请输入工序编号" v-model="queryParam.processid"></a-input>
            </a-form-item>
          </a-col>
          <a-col :md="6" :sm="8">
            <a-form-item label="开始时间">
              <a-input placeholder="请输入开始时间" v-model="queryParam.starttime"></a-input>
            </a-form-item>
          </a-col>
          <a-col :md="6" :sm="8">
            <a-form-item label="作业单编号ID">
              <a-input placeholder="请输入作业单编号ID" v-model="queryParam.workid"></a-input>
            </a-form-item>
          </a-col>
          </template>
          <a-col :md="6" :sm="8" >
            <span style="float: left;overflow: hidden;" class="table-page-search-submitButtons">
              <a-button type="primary" @click="searchQuery" icon="search">查询</a-button>
              <a-button type="primary" @click="searchReset" icon="reload" style="margin-left: 8px">重置</a-button>
              <a @click="handleToggleSearch" style="margin-left: 8px">
                {{ toggleSearchStatus ? '收起' : '展开' }}
                <a-icon :type="toggleSearchStatus ? 'up' : 'down'"/>
              </a>
            </span>
          </a-col>

        </a-row>
      </a-form>
    </div>-->

    <!-- 操作按钮区域 -->
    <div class="table-operator">
      <a-button @click="handleAdd" type="primary" icon="plus" v-has="'pool:add'">新增</a-button>
      <a-button type="primary" icon="download" @click="handleExportXls('加工流水线进度表')">导出</a-button>
      <a-upload name="file" :showUploadList="false" :multiple="false" :headers="tokenHeader" :action="importExcelUrl" @change="handleImportExcel">
        <a-button type="primary" icon="import" v-has="'pool:import'">导入</a-button>
      </a-upload>
      <a-dropdown v-if="selectedRowKeys.length > 0">
        <a-menu slot="overlay">
          <a-menu-item key="1" @click="batchDel"><a-icon type="delete"/>删除</a-menu-item>
        </a-menu>
        <a-button style="margin-left: 8px" v-has="'pool:edits'"> 批量操作 <a-icon type="down" /></a-button>
      </a-dropdown>
    </div>

    <!-- table区域-begin -->
    <div>
      <div class="ant-alert ant-alert-info" style="margin-bottom: 16px;">
        <i class="anticon anticon-info-circle ant-alert-icon"></i> 已选择 <a style="font-weight: 600">{{ selectedRowKeys.length }}</a>项
        <a style="margin-left: 24px" @click="onClearSelected">清空</a>
      </div>

      <a-table
        ref="table"
        size="middle"
        bordered
        rowKey="id"
        :columns="columns"
        :dataSource="dataSource"
        :pagination="ipagination"
        :loading="loading"
        :rowSelection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
        @change="handleTableChange">

        <span slot="action" slot-scope="text, record">
          <a @click="handleEdit(record)" v-has="'pool:edit'">编辑</a>

          <a-divider type="vertical" />
          <a-dropdown>
            <a class="ant-dropdown-link" v-has="'pool:more'">更多 <a-icon type="down" /></a>
            <a-menu slot="overlay">
              <a-menu-item>
                <a-popconfirm title="确定删除吗?" @confirm="() => handleDelete(record.id)">
                  <a v-has="'pool:delete'">删除</a>
                </a-popconfirm>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </span>

      </a-table>
    </div>
    <!-- table区域-end -->

    <!-- 表单区域 -->
    <gsSchedule-modal ref="modalForm" @ok="modalFormOk"></gsSchedule-modal>
  </a-card>
</template>

<script>
  import GsScheduleModal from './modules/GsScheduleModal'
  import { JeecgListMixin } from '@/mixins/JeecgListMixin'

  export default {
    name: "GsScheduleList",
    mixins:[JeecgListMixin],
    components: {
      GsScheduleModal
    },
    data () {
      return {
        description: '加工流水线进度表管理页面',
        // 表头
        columns: [
          {
            title: '#',
            dataIndex: '',
            key:'rowIndex',
            width:60,
            align:"center",
            customRender:function (t,r,index) {
              return parseInt(index)+1;
            }
           },
       {
            title: '作业单编号ID',
            align:"center",
            dataIndex: 'workid'
          },
		   {
            title: '材料批次编码',
            align:"center",
            dataIndex: 'batchid'
           },
       {
            title: '工序编号',
            align:"center",
            dataIndex: 'processid'
          },
       {
            title: '开始时间',
            align:"center",
            dataIndex: 'starttime'
          },
		   {
            title: '结束时间',
            align:"center",
            dataIndex: 'endtime'
           },
		   {
            title: '加工耗时',
            align:"center",
            dataIndex: 'worktime'
           },
          {
            title: '操作',
            dataIndex: 'action',
            align:"center",
            scopedSlots: { customRender: 'action' },
          }
        ],
		url: {
          list: "/system/gsSchedule/getAll",
          delete: "/system/gsSchedule/delete",
          deleteBatch: "/system/gsSchedule/deleteBatch",
          exportXlsUrl: "system/gsSchedule/exportXls",
          importExcelUrl: "system/gsSchedule/importExcel",
       },
    }
  },
  computed: {
    importExcelUrl: function(){
      return `${window._CONFIG['domianURL']}/${this.url.importExcelUrl}`;
    }
  },
    methods: {
     
    }
  }
</script>
<style scoped>
  @import '~@assets/less/common.less'
</style>
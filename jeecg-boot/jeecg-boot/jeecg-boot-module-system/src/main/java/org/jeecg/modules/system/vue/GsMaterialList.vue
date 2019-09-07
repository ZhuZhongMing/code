<template>
  <a-card :bordered="false">

    <!-- 查询区域 -->
    <div class="table-page-search-wrapper">
      <a-form layout="inline">
        <a-row :gutter="24">

          <a-col :md="6" :sm="8">
            <a-form-item label="材料批次编码">
              <a-input placeholder="请输入材料批次编码" v-model="queryParam.batchid"></a-input>
            </a-form-item>
          </a-col>
          <a-col :md="6" :sm="8">
            <a-form-item label="材料类型:(1:xx 2:oo)">
              <a-input placeholder="请输入材料类型:(1:xx 2:oo)" v-model="queryParam.materialid"></a-input>
            </a-form-item>
          </a-col>
        <template v-if="toggleSearchStatus">
        <a-col :md="6" :sm="8">
            <a-form-item label="材料加工模式:(1:xx 2:oo)">
              <a-input placeholder="请输入材料加工模式:(1:xx 2:oo)" v-model="queryParam.processmode"></a-input>
            </a-form-item>
          </a-col>
          <a-col :md="6" :sm="8">
            <a-form-item label="材料加工状态:(1:等待加工 2:正在加工 3:加工完毕)">
              <a-input placeholder="请输入材料加工状态:(1:等待加工 2:正在加工 3:加工完毕)" v-model="queryParam.state"></a-input>
            </a-form-item>
          </a-col>
          <a-col :md="6" :sm="8">
            <a-form-item label="备注">
              <a-input placeholder="请输入备注" v-model="queryParam.remark"></a-input>
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
    </div>

    <!-- 操作按钮区域 -->
    <div class="table-operator">
      <a-button @click="handleAdd" type="primary" icon="plus">新增</a-button>
      <a-button type="primary" icon="download" @click="handleExportXls('加工材料信息表')">导出</a-button>
      <a-upload name="file" :showUploadList="false" :multiple="false" :headers="tokenHeader" :action="importExcelUrl" @change="handleImportExcel">
        <a-button type="primary" icon="import">导入</a-button>
      </a-upload>
      <a-dropdown v-if="selectedRowKeys.length > 0">
        <a-menu slot="overlay">
          <a-menu-item key="1" @click="batchDel"><a-icon type="delete"/>删除</a-menu-item>
        </a-menu>
        <a-button style="margin-left: 8px"> 批量操作 <a-icon type="down" /></a-button>
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
          <a @click="handleEdit(record)">编辑</a>

          <a-divider type="vertical" />
          <a-dropdown>
            <a class="ant-dropdown-link">更多 <a-icon type="down" /></a>
            <a-menu slot="overlay">
              <a-menu-item>
                <a-popconfirm title="确定删除吗?" @confirm="() => handleDelete(record.id)">
                  <a>删除</a>
                </a-popconfirm>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </span>

      </a-table>
    </div>
    <!-- table区域-end -->

    <!-- 表单区域 -->
    <gsMaterial-modal ref="modalForm" @ok="modalFormOk"></gsMaterial-modal>
  </a-card>
</template>

<script>
  import GsMaterialModal from './modules/GsMaterialModal'
  import { JeecgListMixin } from '@/mixins/JeecgListMixin'

  export default {
    name: "GsMaterialList",
    mixins:[JeecgListMixin],
    components: {
      GsMaterialModal
    },
    data () {
      return {
        description: '加工材料信息表管理页面',
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
            title: '材料批次编码',
            align:"center",
            dataIndex: 'batchid'
           },
		   {
            title: '材料类型:(1:xx 2:oo)',
            align:"center",
            dataIndex: 'materialid'
           },
		   {
            title: '材料加工模式:(1:xx 2:oo)',
            align:"center",
            dataIndex: 'processmode'
           },
		   {
            title: '材料加工状态:(1:等待加工 2:正在加工 3:加工完毕)',
            align:"center",
            dataIndex: 'state'
           },
		   {
            title: '备注',
            align:"center",
            dataIndex: 'remark'
           },
          {
            title: '操作',
            dataIndex: 'action',
            align:"center",
            scopedSlots: { customRender: 'action' },
          }
        ],
		url: {
          list: "/system/gsMaterial/list",
          delete: "/system/gsMaterial/delete",
          deleteBatch: "/system/gsMaterial/deleteBatch",
          exportXlsUrl: "system/gsMaterial/exportXls",
          importExcelUrl: "system/gsMaterial/importExcel",
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
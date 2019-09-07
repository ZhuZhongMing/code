<template>
  <div class="page-header-index-wide">
    <a-row :gutter="24">

      <a-layout style="margin: 10px;">
        <a-layout-sider style="background: white; border-right: 5px solid #F0F2F5">
          <a-card title="材料等候列表">
            <a href="#" slot="extra">
              <a-tooltip :title=countMsg>
                <a-icon type="info-circle-o" />
              </a-tooltip>
            </a>
            <p v-for="d in data">
              <span v-if="d.state==1"><b>材料编码：</b>{{d.id}}</span>
            </p>
          </a-card>

        </a-layout-sider>

        <!-- 中间流程概览 -->
        <a-layout>
          <a-layout-header style="background: white;">
            <h1 style="float: left;">流程概览</h1>
            <h2 style="float: right; margin-right: 10%;">{{date}}</h2>
          </a-layout-header>
          <a-layout-content style="background:white; padding: 20px;">


            <!-- 流程开始 -->
            <a-row>
              <a-col :span="2">
                <div class="pools" style="font-size: 15px;">

                  <a-tooltip placement="top" >
                    <template slot="title">
                      <span>此为等候区</span>
                    </template>
                    等候区
                  </a-tooltip>

                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div class="pools" style="font-size: 15px;">
                  开始
                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div class="pools" @click="showDrawer(1)">
                  <a-tooltip placement="top" >
                    <template slot="title">
                      <span>点击查看温度变化记录</span>
                    </template>
                    <span v-if="batchInfo.reactioncellid==1">
                      <a-icon type="loading" />
                    </span>
                    1
                  </a-tooltip>
                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div class="pools" @click="showDrawer(2)">

                  <a-tooltip placement="top" >
                    <template slot="title">
                      <span>点击查看温度变化记录</span>
                    </template>
                    <span v-if="batchInfo.reactioncellid==2">
                      <a-icon type="loading" />
                    </span>
                    2
                  </a-tooltip>
                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div class="pools" @click="showDrawer(3)">
                  <a-tooltip placement="top" >
                    <template slot="title">
                      <span>点击查看温度变化记录</span>
                    </template>
                    <span v-if="batchInfo.reactioncellid==3">
                      <a-icon type="loading" />
                    </span>
                    3
                  </a-tooltip>
                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div class="pools" @click="showDrawer(4)">
                  <a-tooltip placement="top" >
                    <template slot="title">
                      <span>点击查看温度变化记录</span>
                    </template>
                    <span v-if="batchInfo.reactioncellid==4">
                      <a-icon type="loading" />
                    </span>
                    4
                  </a-tooltip>
                </div>
              </a-col>
              <a-col :span="1"></a-col>
            </a-row>

            <a-row>
              <a-col :span="2">
                <div style="height: 50px;">

                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div style="height: 50px;">

                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div style="height: 50px;">

                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div style="height: 50px;">

                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div style="height: 50px;">

                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div style="height: 100px;">

                </div>
              </a-col>
              <a-col :span="1"></a-col>
            </a-row>

            <a-row>
              <a-col :span="2">
                <div class="pools" style="font-size: 15px;">
                  结束
                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div class="pools" @click="showDrawer(9)">
                  <a-tooltip placement="top" >
                    <template slot="title">
                      <span>点击查看温度变化记录</span>
                    </template>
                    <span v-if="batchInfo.reactioncellid==9">
                      <a-icon type="loading" />
                    </span>
                    9
                  </a-tooltip>
                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div class="pools" @click="showDrawer(8)">
                  <a-tooltip placement="top" >
                    <template slot="title">
                      <span>点击查看温度变化记录</span>
                    </template>
                    <span v-if="batchInfo.reactioncellid==8">
                      <a-icon type="loading" />
                    </span>
                    8
                  </a-tooltip>
                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div class="pools" @click="showDrawer(7)">
                  <a-tooltip placement="top" >
                    <template slot="title">
                      <span>点击查看温度变化记录</span>
                    </template>
                    <span v-if="batchInfo.reactioncellid==7">
                      <a-icon type="loading" />
                    </span>
                    7
                  </a-tooltip>
                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div class="pools" @click="showDrawer(6)">
                  <a-tooltip placement="top" >
                    <template slot="title">
                      <span>点击查看温度变化记录</span>
                    </template>
                    <span v-if="batchInfo.reactioncellid==6">
                      <a-icon type="loading" />
                    </span>
                    6
                  </a-tooltip>
                </div>
              </a-col>
              <a-col :span="1"></a-col>
              <a-col :span="3">
                <div class="pools" @click="showDrawer(5)">
                  <a-tooltip placement="top" >
                    <template slot="title">
                      <span>点击查看温度变化记录</span>
                    </template>
                    <span v-if="batchInfo.reactioncellid==5">
                      <a-icon type="loading" />
                    </span>
                    5
                  </a-tooltip>
                </div>
              </a-col>
              <a-col :span="1"></a-col>
            </a-row>

          </a-layout-content>
          <!-- 底部信息 -->
          <a-layout-footer style="background: white; border-top:  5px solid #F0F2F5;">

            <a-card title="当前加工材料信息">

              <p>
                  <span v-if="batchInfo.batchid!=null"><b>材料编码：</b>{{batchid}}<br/></span>
                  <span v-if="batchInfo.processname!=null"><b>当前工序：</b>{{batchInfo.processname}}<br/></span>
                  <span v-if="batchInfo.reactioncellname!=null"><b>当前池位：</b>{{batchInfo.reactioncellname}}<br/></span>
                  <span v-if="batchInfo.processtime!=null"><b>工序耗时：</b>{{batchInfo.processtime}} / 秒<br/></span>
                  <span v-if="batchInfo.starttime!=null"><b>开始时间：</b>{{batchInfo.starttime}}<br/></span>

              </p>
            </a-card>
          </a-layout-footer>
        </a-layout>
      </a-layout>



     </a-row>


    <a-drawer
      title="温度变化记录"
      :placement="placement"
      :closable="true"
      @close="onClose"
      :visible="visible"
      width="60%"
    >

      <!-- 实时图例 -->
      <div>
        <v-chart :forceFit="true" :height="height" :data="datasource" :scale="scale" :padding="padding">
          <v-tooltip  />
          <v-axis />
          <v-legend :attachLast="true" />
          <v-legend dataKey="predict" :show="false" />
          <v-line position="time*value" shape="circle" :color="color"
                  :size="2"
                  :animate="animate"
          />
          <!--<v-point position="year*value" shape="circle"  smooth />-->
          <v-guide
            type="line"
            :top="true"
            :start="start1"
            :end="end1"
            :lineStyle="linestyle"
            :text="text"
          />
          <!-- regionFilter  :apply="apply"  color="#F5222D"  -->
          <v-guide
            type="line"
            :top="true"
            :start="start2"
            :end="end2"
            :lineStyle="linestyle"
            :text="text1"
          />
          <v-guide
            type="dataMarker"
            :top="true"
            content="当前最大峰值"
            :position="getDataMarkerOptsposition(datasource)"
            style="dataMarkerOpts.style"
            :lineLength="50"
          />
        </v-chart>
      </div>

    </a-drawer>



    <!--首页-->
  </div>
</template>

<script>
  import ChartCard from '@/components/ChartCard'
  import ACol from "ant-design-vue/es/grid/Col"
  import ATooltip from "ant-design-vue/es/tooltip/Tooltip"
  import MiniArea from '@/components/chart/MiniArea'
  import MiniBar from '@/components/chart/MiniBar'
  import MiniProgress from '@/components/chart/MiniProgress'
  import RankList from '@/components/chart/RankList'
  import Bar from '@/components/chart/Bar'
  import LineChartMultid from '@/components/chart/LineChartMultid'
  import HeadInfo from '@/components/tools/HeadInfo.vue'
  import {getAction} from '@/api/manage'
  import Trend from '@/components/Trend'
  import { JeecgListMixin } from '@/mixins/JeecgListMixin'



  function findMax(data) {
    var maxValue = 0;
    var maxObj = null;
    for (var i = 0; i < data.length; i++) {
      var d = data[i];
      if (d.value > maxValue /* && d.type === 'today'*/) {
        maxValue = d.value;
        maxObj = d;
      }
    }
    return maxObj;
  }
  const scale = [
    /*tickCount: 10,*/
    {
      dataKey: 'time',
      alias: '时间',
      type: 'time',
      mask: 'hh:mm:ss',
      nice: true,
      tickCount: 60,
    },
    {
      dataKey: 'value',
      alias: '温度',
      min: 0,
      max: 100,
    },
    {
      dataKey: 'type',
      type: 'cat',
    },
  ];






  export default {
    name: "Analysis",
  /*  mixins:[JeecgListMixin],*/
    components: {
      ATooltip,
      /*ACol,
      ChartCard,
      MiniArea,
      MiniBar,
      MiniProgress,
      RankList,
      Bar,
      Trend,
      LineChartMultid,
      HeadInfo,*/
      getAction,
    },
    data() {
      return {
        /*材料信息*/
        data:[],//获取未加工完毕材料信息
        countMsg:'',//等待加工材料统计数量提示信息
        batchid:'',//当前正在加工材料批次编号
        batchInfo:{
          reactioncellid:0,
        },
        date:'',
        visible: false,
        placement: 'left',
        /*indicator: <a-icon type="loading" style="font-size: 24px" spin />*/
        datasource: [],
        scale,
        height: 440,
        padding: [10, 100, 50, 50],
        color:['type', ['#2593fc', '#cccccc']],
        start1:['min', 70],
        end1:['max', 70],
        start2:['min', 20],
        end2:['max', 20],
        apply:['line'],
        animate:{
          update: {
            duration: 0,
          },
        },
        linestyle:{
          stroke: '#F5222D',
          lineWidth: 2,
        },
        text:{
          content: '最高预警线',
          position: 'start',
          offsetX: 20,
          offsetY: -5,
        },
        text1:{
          content: '最底预警线',
          position: 'start1',
          offsetX: 40,
          offsetY: -10,
        },
        dataMarkerOpts:{
          style: {
            text: {
              fontSize: 13,
            },
            point: {
              stroke: '#606060',
            },
          }
        }




      }
    },
    created() {
      setInterval(() => {

        //获取系统当前时刻
        var date=new Date();
        /*this.date.year=date.getFullYear();
        this.date.month=(date.getMonth()+1);
        this.date.day=date.getDate();
        this.date.hour=date.getHours();
        this.date.minute=date.getMinutes();
        this.date.second=date.getSeconds();*/
        this.date='当前时刻：'+date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+'   '+date.getHours()+'-'+date.getMinutes()+'-'+date.getSeconds()


        /*获取未加工完毕材料信息*/
        const data = this.$data.data;
        getAction('/system/gsMaterial/queryListInfo',null).then((res)=>{
          if(res.success){
            //清空data
            data.length=[];
            var results=res.result;
            if (res.result!=null){



              for (let i = 0; i < res.result.length; i++) {
                data.push({
                  id: results[i].batchid,
                  state: results[i].state,
                })
                //正在加工材料
                if(results[i].state==2){
                  this.batchid=results[i].batchid
                }
              }
              this.countMsg="当前"+data.length+"批材料正在等候加工";
              //获取当前正在加工材料信息
              getAction('/system/gsMaterial/getInfo',{'batchid':this.batchid}).then((res)=>{
                if(res.success){
                  this.batchInfo.batchid=res.result.batchid;//材料批次编号
                  this.batchInfo.processid=res.result.processid;//工序编号
                  this.batchInfo.processname=res.result.processname;//工序名称
                  this.batchInfo.reactioncellid=res.result.reactioncellid;//反应池编号
                  this.batchInfo.reactioncellname=res.result.reactioncellname;//反应池名称
                  this.batchInfo.processtime=res.result.processtime;//工序耗时
                  this.batchInfo.starttime=res.result.starttime;//开始时间
                }
              });
            }
          }
        });

      }, 500);
    },
    methods: {
      showDrawer(par) {
        let param = {
          'reactioncellid':par,
          'batchid':this.batchid
        }
       /* let param = JSON.stringify({
          'reactioncellid':par,
          'batchid':this.batchid
        });*/
                                                   //this.batchInfo.reactioncellid
        getAction('/system/gsTemperature/queryListByReactionCellId', param).then((res)=>{
          if(res.success){
            //this.massage = res.result;
            //console.log("结果："+JSON.stringify(res.result))
            //var results = new Array();
            if(res.result.length==0){
              this.$message.warning('此反应池暂无当前温度变化信息');
            }else{
              var results=res.result;
              for (let i = 0; i < res.result.length; i++) {
                this.datasource.push({
                  time: results[i].writetime,
                  value: parseInt(results[i].temperature),
                  type: results[i].reactioncellid,
                })
              }
              this.visible = true
            }

          }
        })


      },
      onClose() {
        //清空之前获取的数据
        //this.datasource.length=0;
        //this.datasource=[];
        this.visible = false

      },

      getDataMarkerOptsposition: (data) => {
        var obj = findMax(data);
        if (obj) {
          return [obj.time, obj.value];
        }
        return [0, 0];
      },

    }
  }
</script>

<style lang="scss" scoped>
  .pools{
    font-size: 20px;
    color: white;
    border-radius: 30px;
    background: rgba(0, 160, 233, 0.6);//#00A0E9;
    line-height: 50px;
    text-align: center;
  }
</style>
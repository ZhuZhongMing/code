<template>
  <div>
    <a-form style="max-width: 1000px; width: 100%; margin: 40px auto 0;">


      <!-- 实时图例 -->
      <div>
        <v-chart :forceFit="true" :height="height" :data="data" :scale="scale" :padding="padding">
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
            :position="getDataMarkerOptsposition(data)"
            style="dataMarkerOpts.style"
            :lineLength="50"
          />
        </v-chart>
      </div>



      <a-button type="primary" @click="nextStep">下一步</a-button>
    </a-form>
  </div>
</template>

<script>

  import {getAction} from '@/api/manage'


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
    name: "Step1",
    mounted () {
        const data = this.$data.data;
        getAction('/system/gsTemperature/queryListByReactionCellId',{'reactioncellid':'1'}).then((res)=>{
          if(res.success){
            //this.massage = res.result;
            //console.log("结果："+JSON.stringify(res.result))
            //var results = new Array();
            var results=res.result;
            console.log("长度："+res.result.length)
            for (let i = 0; i < res.result.length; i++) {

              /*var d=JSON.stringify(results[i]);
              console.log("time："+JSON.stringify(results[i]))
              console.log("time："+results[i].writetime)
              console.log("value："+results[i].temperature)
              console.log("type："+results[i].reactioncellid)*/

              data.push({
                time: results[i].writetime,
                value: parseInt(results[i].temperature),
                type: results[i].reactioncellid,
              })

            }
          }
        })
        /*data.push({
          time: time,
          value: value1,
          type: 'today',
        });*/



    },
    components: {
      getAction
    },
    data() {
      return {
        data: [],
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
      };
    },
    methods: {
      nextStep () {
        this.$emit('nextStep')
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
  .stepFormText {
    margin-bottom: 24px;
    .ant-form-item-label,
    .ant-form-item-control {
      line-height: 22px;
    }
  }

</style>



<!--
getAction('/system/gsSchedule/getAll',null).then((res)=>{
if(res.success){
this.massage = res.result;
}
})-->

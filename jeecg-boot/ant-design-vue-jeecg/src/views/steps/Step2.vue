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


      <a-form-item :wrapperCol="{span: 19, offset: 5}">
        <a-button type="primary" @click="nextStep">下一步</a-button>
        <a-button style="margin-left: 8px" @click="prevStep">上一步</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>

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
    name: "Step2",
    comments: {
      G2
    },
    // mounted
    created() {
      setInterval(() => {
        const data = this.$data.data;
        var now = new Date();
        var time = now.getTime();
        var value1 = ~~30 + Math.random() * 50;
        var direction = Math.random() > 0.5 ? 1 : -1;
        //var value2 = value1 + Math.random() * 20 * direction;
        if (data.length >= 60) {
          data.shift();
          /*data.shift();*/
        }
       /* data.push({
          time: time,
          value: value2,
          type: 'yesterday',
        });*/
        data.push({
          time: time,
          value: value1,
          type: 'today',
        });

        if (data.length > 60) {
          data.shift();
          /*data.shift();*/
        }
      }, 1000);
    },
    methods: {
      nextStep () {
       this.$emit('nextStep')
      },
      prevStep () {
        this.$emit('prevStep')
      },
      getDataMarkerOptsposition: (data) => {
        var obj = findMax(data);
        if (obj) {
          return [obj.time, obj.value];
        }
        return [0, 0];
      },
    },
    data() {
      return {
        data: [],
        scale,
        height: 440,
        padding: [10, 100, 50, 50],
        color:['type', ['#2593fc', '#cccccc']],
        start1:['min', 90],
        end1:['max', 90],
        start2:['min', 10],
        end2:['max', 10],
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
          content: '预警线1',
          position: 'start',
          offsetX: 20,
          offsetY: -5,
        },
        text1:{
          content: '预警线2',
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
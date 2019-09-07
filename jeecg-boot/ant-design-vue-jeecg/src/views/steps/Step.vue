<template>
  <a-card :bordered="false">
    <a-steps class="steps" :current="currentTab" size="small"><!-- 设置当前步骤状态 status="error"-->
      <!-- 设置状态，可选： status="error" process，finish，wait -->
      <a-step title="槽一"><a-icon type="user" slot="icon"/></a-step>
      <a-step title="槽二"><a-icon type="phone" slot="icon"/></a-step>
      <a-step title="槽三"><a-icon type="apple" slot="icon"/></a-step>
      <a-step direction="vertical" title="槽四"><a-icon type="android" slot="icon"/></a-step>
      <a-step title="槽五"><a-icon type="setting" slot="icon"/></a-step>
      <a-step direction="vertical" title="槽六"><a-icon type="robot" slot="icon"/></a-step>
      <a-step title="槽七"><a-icon type="meh" slot="icon"/></a-step>
      <a-step direction="vertical" title="槽八"><a-icon type="smile" slot="icon"/></a-step>
      <a-step title="槽九"><a-icon type="frown" slot="icon"/></a-step>

    </a-steps>
    <div class="content">
      <step1 v-if="currentTab === 0" @nextStep="nextStep"/>
      <step2 v-if="currentTab === 1" @nextStep="nextStep" @prevStep="prevStep"/>
      <step3 v-if="currentTab === 2" @nextStep="nextStep" @prevStep="prevStep"/>
      <step4 v-if="currentTab === 3" @nextStep="nextStep" @prevStep="prevStep"/>
      <step5 v-if="currentTab === 4" @nextStep="nextStep" @prevStep="prevStep"/>
      <step6 v-if="currentTab === 5" @nextStep="nextStep" @prevStep="prevStep"/>
      <step7 v-if="currentTab === 6" @nextStep="nextStep" @prevStep="prevStep"/>
      <step8 v-if="currentTab === 7" @nextStep="nextStep" @prevStep="prevStep"/>
      <step9 v-if="currentTab === 8" @prevStep="prevStep" @finish="finish"/>
    </div>
  </a-card>
</template>

<script>
  import Step1 from './Step1'
  import Step2 from './Step2'
  import Step3 from './Step3'
  import Step4 from './Step4'
  import Step5 from './Step5'
  import Step6 from './Step6'
  import Step7 from './Step7'
  import Step8 from './Step8'
  import Step9 from './Step9'

  export default {
    name: "StepForm",
    components: {
      Step1,
      Step2,
      Step3,
      Step4,
      Step5,
      Step6,
      Step7,
      Step8,
      Step9,
    },
    data () {
      return {
        description: '将一个冗长或用户不熟悉的表单任务分成多个步骤，指导用户完成。',
        currentTab: 0,
        // form
        form: null,
      }
    },
    methods: {

      // handler
      nextStep () {
        if (this.currentTab < 8) {
          this.currentTab += 1
        }
      },
      prevStep () {
        if (this.currentTab > 0) {
          this.currentTab -= 1
        }
      },
      finish () {
        this.currentTab = 0
      }
    }

  }
</script>

<style lang="scss" scoped>
  .steps {
    max-width: 1000px;
    width: 100%;
    margin: 16px auto;
  }
</style>
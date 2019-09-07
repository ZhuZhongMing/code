<template>
  <div>
    <a-form style="max-width: 500px; margin: 40px auto 0;">
      <a-form-item :wrapperCol="{span: 19, offset: 5}">
        <a-button type="primary" @click="nextStep">下一步</a-button>
        <a-button style="margin-left: 8px" @click="prevStep">上一步</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
  export default {
    name: "Step5",
    methods: {
      nextStep () {
        this.$emit('nextStep')
      },
      prevStep () {
        this.$emit('prevStep')
      }
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
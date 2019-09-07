<template>
  <div>
    <a-form style="max-width: 500px; margin: 40px auto 0;">
      <a-form-item :wrapperCol="{span: 19, offset: 5}">
        <a-button style="margin-left: 8px" @click="prevStep">上一步</a-button>
        <a-button type="primary" @click="finish">完成</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
  export default {
    name: "Step9",
    data () {
      return {
        loading: false
      }
    },
    methods: {
      finish () {
        this.$emit('finish')
      },
      prevStep () {
        this.$emit('prevStep')
      }
    }
  }
</script>

<style lang="scss" scoped>
  .information {
    line-height: 22px;

    .ant-row:not(:last-child) {
      margin-bottom: 24px;
    }
  }
  .money {
    font-family: "Helvetica Neue",sans-serif;
    font-weight: 500;
    font-size: 20px;
    line-height: 14px;
  }
</style>
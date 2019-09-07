<template>
  <div>
    <a-form style="margin: 40px auto 0;">
      <!--<result title="操作成功" :is-success="true" description="预计两小时内到账">
        <div class="information">
          <a-row>
            <a-col :sm="8" :xs="24">付款账户：</a-col>
            <a-col :sm="16" :xs="24">ant-design@alipay.com</a-col>
          </a-row>
          <a-row>
            <a-col :sm="8" :xs="24">收款账户：</a-col>
            <a-col :sm="16" :xs="24">test@example.com</a-col>
          </a-row>
          <a-row>
            <a-col :sm="8" :xs="24">收款人姓名：</a-col>
            <a-col :sm="16" :xs="24">辉夜</a-col>
          </a-row>
          <a-row>
            <a-col :sm="8" :xs="24">转账金额：</a-col>
            <a-col :sm="16" :xs="24"><span class="money">500</span> 元</a-col>
          </a-row>
        </div>
        <div slot="action">
          <a-button type="primary" @click="finish">再转一笔</a-button>
          <a-button style="margin-left: 8px" @click="toOrderList">查看账单</a-button>
        </div>
      </result>-->
      <a-form-item :wrapperCol="{span: 19, offset: 5}">
        <a-button type="primary" @click="nextStep">下一步</a-button>
        <a-button style="margin-left: 8px" @click="prevStep">上一步</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>


  export default {
    name: "Step3",
    methods: {
      /*finish () {
        this.$emit('finish')
      },
      toOrderList () {
        this.$router.push('/list/query-list')
      }*/
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
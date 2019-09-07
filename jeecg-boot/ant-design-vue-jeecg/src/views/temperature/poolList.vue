<template>
  <a-card :bordered="false">
      接口信息：{{massage}}
  </a-card>
</template>

<script>
  import STable from '@/components/table/'
  import { getRoleList, getServiceList } from '@/api/manage'
  import { getAction } from '@/api/manage'

  export default {
    name: "TableList",
    components: {
      STable,
      getAction
    },
    data () {
      return {
        massage:"ss"
      }
    },
    created () {
      getAction('/my/testDemo/hello',null).then((res)=>{
        if(res.success){
          this.massage = res.result;
        }
      })
    },
    methods: {

    },
    watch: {

    }
  }
</script>
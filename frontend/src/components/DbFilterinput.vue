<template>
    <el-form :inline="true" :model="formInline">
        <el-form-item  label="厂家名称">
            <el-input v-model="formInline.name" placeholder="请输入厂家名称"></el-input>
        </el-form-item>
    </el-form>
</template>

<script>
    import lodash from 'lodash'
    import Bus from '../eventBus'

    export default {
        name: 'db-filterinput',
        data() {
            return {
                type_options: [],
                formInline: {
                    name: ''
                },
                formLabelWidth: '120px'
            }
        },

        watch: {
            'formInline.name': 'filterResultData'
        },

        methods: {
            filterResultData: _.debounce(
                function () {
                    this.$axios.get("http://127.0.0.1:8000/factory/list", {
                        params: {
                            name: this.formInline.name,
                        }
                    }).then((response) => {
                        Bus.$emit('filterResultData', response.data);
                        console.log(response.data);
                    }).catch(function (response) {
                        console.log(response)
                    });

                },
                500
            ),
        }
    }


</script>
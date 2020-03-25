//region vue全局filter
Vue.filter('langFilter', function(value) {
    let methods = myMixin.methods;
    return value[methods.getLang()];
})
//endregion
//region vue全局混入
const myMixin = {
    data () {
        return {
            langDetails: langDetails,
        }
    },
    methods: {
        getLang: function() {
            return localStorage.getItem("LANG_TYPE") ? localStorage.getItem("LANG_TYPE") : "zhCn";
        },
    }
}
//endregion

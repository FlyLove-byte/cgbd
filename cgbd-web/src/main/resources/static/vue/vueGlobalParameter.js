//region vue全局filter
Vue.filter('langFilter', function(value) {
    let methods = myMixin.methods;
    return value[methods.getLang()];
})
//endregion
//region vue全局混入
const myMixin = {
    data () {
        let langFilter = this.$options.filters['langFilter'];
        return {
            langDetails: langDetails,
            userInfo: {
                title: langFilter (langDetails["UserInformation"]),
                url: "/redirect/civilServant"
            },
            info: {
                title: langFilter (langDetails["News"]),
                url: "/redirect/civilServant"
            },
            set: {
                title: langFilter (langDetails["set"]),
                url: "/redirect/civilServant"
            },
            doExit: {
                title: langFilter (langDetails["SignOut"]),
                url: "/redirect/civilServant"
            },
        }
    },
    methods: {
        getLang: function() {
            return localStorage.getItem("LANG_TYPE") ? localStorage.getItem("LANG_TYPE") : "zhCn";
        },
    }
}
//endregion

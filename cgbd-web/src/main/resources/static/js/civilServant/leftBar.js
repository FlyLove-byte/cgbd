const app = new Vue({
    mixins: [myMixin],
    data () {
        let langFilter = this.$options.filters['langFilter'];
        return {
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
}).$mount('#sidebar')


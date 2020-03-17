const app = new Vue({
    data () {
        return {
            userInfo: {
                title: "用户信息",
                url: "/redirect/civilServant"
            },
            info: {
                title: "消息",
                url: "/redirect/civilServant"
            },
            set: {
                title: "设置",
                url: "/redirect/civilServant"
            },
            doExit: {
                title: "退出",
                url: "/redirect/civilServant"
            },
        }
    },
}).$mount('#sidebar')


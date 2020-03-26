//region vue全局filter
Vue.filter('langFilter', function(value) {
    let methods = myMixin.methods;
    let langDetail;
    try {
        langDetail = langDetails[value][methods.getLang()];
    }catch (e) {
        console.error(value);
        console.error(e);
    }
    return langDetail;
})
Vue.filter('langSetFilter', function(value) {
    let langDetail;
    try {
        //语言包和键要一样
        langDetail = langDetails[value][value];
    }catch (e) {
        console.error(value);
        console.error(e);
    }
    return langDetail;
})
//endregion
//region vue全局混入
const myMixin = {
    data () {
        let langFilter = this.$options.filters['langFilter'];
        return {
            langDetails: langDetails,
            languages: languages,
            userInfo: {
                title: langFilter ("UserInformation"),
                url: "/redirect/civilServant"
            },
            info: {
                title: langFilter ("News"),
                url: "/redirect/civilServant"
            },
            set: {
                title: langFilter ("set"),
                url: "/redirect/civilServant"
            },
            doExit: {
                title: langFilter ("SignOut"),
                url: "/redirect/civilServant"
            },
        }
    },
    methods: {
        getLang: function() {
            return localStorage.getItem("LANG_TYPE") ? localStorage.getItem("LANG_TYPE") : "zhCn";
        },
        setLang: function (e) {
            let thisItem = e.getTarget();
            console.log($(thisItem).val());
            localStorage.setItem("LANG_TYPE", $(thisItem).val());
        }
    }
}
//endregion

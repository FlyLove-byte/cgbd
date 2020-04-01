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
        let methods = this.$options.methods;
        return {
            langDetails: null,
            languages: null,
            language: null,
            userInfo: null,
            info: null,
            set: null,
            doExit: null,
        }
    },
    created() {
        this.formatPage();
    },
    methods: {
        formatPage: function() {
            this.langDetailsFormat();
            this.languagesFormat();
            this.languageFormat();
            this.userInfoFormat();
            this.infoFormat();
            this.setFormat();
            this.doExitFormat();
        },
        langDetailsFormat: function() {
            let langFilter = this.$options.filters['langFilter'];
            let languageFormat = {};
            for(let langDetail in langDetails){
                languageFormat[langDetail] = langFilter(langDetail);
            }
            this.langDetails = languageFormat;
        },
        languagesFormat:function(){
            this.languages = languages;
        },
        languageFormat:function(){
            this.language = this.getLang();
        },
        userInfoFormat: function() {
            this.userInfo = {
                title: this.langDetails["UserInformation"],
                url: "/redirect/civilServant"
            }
        },
        infoFormat: function() {
            this.info = {
                title: this.langDetails["News"],
                url: "/redirect/civilServant"
            }
        },
        setFormat: function() {
            this.set = {
                title: this.langDetails["set"],
                url: "/redirect/civilServant"
            }
        },
        doExitFormat: function() {
            this.doExit = {
                title: this.langDetails["SignOut"],
                url: "/redirect/civilServant"
            }
        },

        mesBox: function(mes, level) {
            let levelColor = 'alert-success';
            if(level == 1) levelColor = 'alert-danger';
            else if(level == 2) levelColor = 'alert-warning';
            let mesBox = '<div style="z-index: 1050" class="mesStyle alert '+ levelColor +'">'+ mes +'</div>';
            $('body').append(mesBox);
            setTimeout(function () {
                $('body>.mesStyle').remove();
            },2500)
        },
        confirmModalOpen: function(tips, title, fun) {
            $("#confirmModal .modal-title").text(tips);
            $("#confirmModal .modal-body>p").text(title);
            $("#confirmModal .confirmOk").click(function () {
                fun();
            })
            $("#confirmModal").modal('show');
        },
        refreshIcon: function() {
            let refreshIcon = '<div class="fa fa-refresh fa-spin refreshIcon"></div>';
            $('body').append(refreshIcon);
        },
        refreshOk: function() {
            $('body .refreshIcon').remove();
        },
        getLang: function() {
            return localStorage.getItem("LANG_TYPE") ? localStorage.getItem("LANG_TYPE") : "zhCn";
        },
        setLang: function (key) {
            localStorage.setItem("LANG_TYPE", key);
            this.formatPage();
            if(this.hasOwnProperty("indexFormat")) this.indexFormat();
        },
    }
}
//endregion

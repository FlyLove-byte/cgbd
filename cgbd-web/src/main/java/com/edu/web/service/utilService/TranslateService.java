package com.edu.web.service.utilService;

import com.edu.web.utils.Translate;
import com.edu.web.utils.TranslateInfo;

public interface TranslateService {

    Translate getTranslateValue(String translateValue, String from);

    boolean exportInit(TranslateInfo translateInfo);

    boolean exportSql(TranslateInfo translateInfo);

    boolean exportHtml(TranslateInfo translateInfo);
}

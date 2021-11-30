package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Cat;
import com.anma.sb.dbdeneratorsb.models.web.CatWeb;

public interface CatToWebCat {
    public Cat convert(CatWeb catWeb);
    public CatWeb convert(Cat cat);
}

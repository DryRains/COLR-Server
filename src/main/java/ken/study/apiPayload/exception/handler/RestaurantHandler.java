package ken.study.apiPayload.exception.handler;

import ken.study.apiPayload.code.BaseErrorCode;
import ken.study.apiPayload.exception.GeneralException;

public class RestaurantHandler extends GeneralException {

    public RestaurantHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

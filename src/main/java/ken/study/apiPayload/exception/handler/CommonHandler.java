package ken.study.apiPayload.exception.handler;

import ken.study.apiPayload.code.BaseErrorCode;
import ken.study.apiPayload.exception.GeneralException;

public class CommonHandler extends GeneralException {
    public CommonHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

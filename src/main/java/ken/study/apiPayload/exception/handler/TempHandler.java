package ken.study.apiPayload.exception.handler;

import ken.study.apiPayload.code.BaseErrorCode;
import ken.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

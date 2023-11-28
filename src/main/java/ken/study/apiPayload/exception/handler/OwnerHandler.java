package ken.study.apiPayload.exception.handler;

import ken.study.apiPayload.code.BaseErrorCode;
import ken.study.apiPayload.exception.GeneralException;

public class OwnerHandler extends GeneralException {
    public OwnerHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

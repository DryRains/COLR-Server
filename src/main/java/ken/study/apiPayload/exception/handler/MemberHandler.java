package ken.study.apiPayload.exception.handler;

import ken.study.apiPayload.code.BaseErrorCode;
import ken.study.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

package ken.study.apiPayload.exception.handler;

import ken.study.apiPayload.code.BaseErrorCode;
import ken.study.apiPayload.exception.GeneralException;

public class FoodHandler extends GeneralException {
   public FoodHandler(BaseErrorCode errorCode){
       super(errorCode);
   }
}

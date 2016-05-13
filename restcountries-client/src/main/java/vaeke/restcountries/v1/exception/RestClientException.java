package vaeke.restcountries.v1.exception;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;

import vaeke.restcountries.v1.data.ErrorMessage;


public class RestClientException extends Exception
{
  private static final long serialVersionUID = 7360783673606191576L;

  private int statusCode_;
  private ErrorMessage errorMessage;
  
  public RestClientException(Response response)
  {
    statusCode_ = response.getStatus();
    try {
      errorMessage = response.readEntity(ErrorMessage.class);
    } catch (ProcessingException e) {
      errorMessage = null;
    }
  }
  
  public RestClientException(int statusCode, ErrorMessage errorMessage)
  {
    statusCode_ = statusCode;
    errorMessage = errorMessage;
  }
  
  public int getStatusCode()
  {
    return statusCode_;
  }
  
  public ErrorMessage getErrorMessage()
  {
    return errorMessage;
  }
  
  @Override
  public String getMessage(){
    String message = "Rest Client Exception: Status Code: " + statusCode_ + " ";
    if(errorMessage != null){
      message += "Error Messages: " + errorMessage.getErrorMessageList();
    }
    
    return message;
    
  }
  
}


package Handlers;

import Models.User;

/**
 *
 * @author ryadh
 */
public abstract class BaseHandler<T> {
    protected BaseHandler _nextHandler;
    public boolean check=true;
    public void setNext(BaseHandler handler){
    _nextHandler = handler;
    }
    
    public abstract void HandlerRequest(T model);
}

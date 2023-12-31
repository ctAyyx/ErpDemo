package com.king.frame.mvvmframe.base;

import android.app.Application;
import android.os.Message;

import com.king.frame.mvvmframe.base.livedata.MessageEvent;
import com.king.frame.mvvmframe.base.livedata.SingleLiveEvent;
import com.king.frame.mvvmframe.base.livedata.StatusEvent;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * MVVMFrame 框架基于 Google 官方的 JetPack 构建，在使用 MVVMFrame 时，需遵循一些规范：
 *
 * <p>如果您继承使用了 BaseViewModel 或其子类，你需要参照如下方式在类上添加 @HiltViewModel 并在构造函数上添加 @Inject 注解
 *
 * <p>Example:
 * <pre>
 *    &#64;HiltViewModel
 *    public class YourViewModel extends BaseViewModel<YourModel> {
 *        &#64;Inject
 *        public DataViewModel(@NonNull Application application, YourModel model) {
 *            super(application, model);
 *        }
 *    }
 * </pre>
 *
 * <p>如果您继承使用了 BaseModel 或其子类，你需要参照如下方式在构造函数上添加 @Inject 注解
 *
 * <p>Example:
 * <pre>
 *    public class YourModel extends BaseModel {
 *        &#64;Inject
 *        public BaseModel(IDataRepository dataRepository){
 *            super(dataRepository);
 *        }
 *    }
 * </pre>
 *
 * <p>MVVM模式中的VM (ViewModel)层基类
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class BaseViewModel<M extends BaseModel> extends AndroidViewModel implements IViewModel {


    /**
     * 请通过 {@link #getModel()} 获取
     */
    private M mModel;

    /**
     * 消息事件
     */
    private final MessageEvent mMessageEvent = new MessageEvent();
    /**
     * 状态事件
     */
    private final StatusEvent mStatusEvent = new StatusEvent();

    /**
     * 加载状态
     */
    private final SingleLiveEvent<Boolean> mLoadingEvent = new SingleLiveEvent<>();

    /**
     * 提供自定义单一消息事件
     */
    private final SingleLiveEvent<Message> mSingleLiveEvent  = new SingleLiveEvent<>();

    /**
     * 继承者都将使用此构造
     * @param application
     * @param model
     */
    public BaseViewModel(@NonNull Application application, M model) {
        super(application);
        this.mModel = model;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        if(mModel != null){
            mModel.onDestroy();
            mModel = null;
        }
    }

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {

    }

    /**
     * {@link M}
     * @return {@link #mModel}
     */
    public M getModel(){
        return this.mModel;
    }

    /**
     *  暴露给观察者提供加载事件，{@link BaseActivity} 或 {@link BaseFragment} 已默认注册加载事件，
     *  只需调用{@link #showLoading()} 或 {@link #hideLoading()}即可在{@link BaseActivity}
     *  或 {@link BaseFragment} 中收到订阅事件
     * @return {@link #mLoadingEvent}
     */
    public SingleLiveEvent<Boolean> getLoadingEvent(){
        return mLoadingEvent;
    }

    /**
     * 暴露给观察者提供消息事件，通过注册{@link BaseActivity#registerMessageEvent(MessageEvent.MessageObserver)}或
     * {@link BaseFragment#registerMessageEvent(MessageEvent.MessageObserver)} 或
     * {@link BaseDialogFragment#registerMessageEvent(MessageEvent.MessageObserver)}接收消息事件
     * @return {@link #mMessageEvent}
     */
    public MessageEvent getMessageEvent(){
        return mMessageEvent;
    }

    /**
     * 暴露给观察者提供状态变化事件，通过注册{@link BaseActivity#registerStatusEvent(StatusEvent.StatusObserver)}或
     * {@link BaseFragment#registerStatusEvent(StatusEvent.StatusObserver)} 或
     * {@link BaseDialogFragment#registerStatusEvent(StatusEvent.StatusObserver)}接收消息事件
     * @return {@link #mStatusEvent}
     */
    public StatusEvent getStatusEvent(){
        return mStatusEvent;
    }

    /**
     * 暴露给观察者提供接收单个消息事件，通过注册{@link BaseActivity#registerSingleLiveEvent(Observer)}或
     * {@link BaseFragment#registerSingleLiveEvent(Observer)} 或
     * {@link BaseDialogFragment#registerSingleLiveEvent(Observer)}接收消息事件
     * @return {@link #mSingleLiveEvent}
     */
    public SingleLiveEvent<Message> getSingleLiveEvent(){
        return mSingleLiveEvent;
    }

    /**
     * 发送消息，通过注册{@link BaseActivity#registerMessageEvent(MessageEvent.MessageObserver)}或
     * {@link BaseFragment#registerMessageEvent(MessageEvent.MessageObserver)} 或
     * {@link BaseDialogFragment#registerMessageEvent(MessageEvent.MessageObserver)}接收消息事件，
     * 也可通过观察{@link #getMessageEvent()}接收消息事件
     * @param msgId 资源文件id
     */
    @MainThread
    public void sendMessage(@StringRes int msgId) {
        sendMessage(msgId,false);
    }

    /**
     * 发送消息，通过注册{@link BaseActivity#registerMessageEvent(MessageEvent.MessageObserver)}或
     * {@link BaseFragment#registerMessageEvent(MessageEvent.MessageObserver)} 或
     * {@link BaseDialogFragment#registerMessageEvent(MessageEvent.MessageObserver)}接收消息事件，
     * 也可通过观察{@link #getMessageEvent()}接收消息事件
     * @param msgId 资源文件id
     * @param post 如果为{@code true}则可以在子线程调用，相当于调用{@link MutableLiveData#postValue(Object)}，
     *             如果为{@code false} 相当于调用{@link MutableLiveData#setValue(Object)}
     */
    public void sendMessage(@StringRes int msgId, boolean post) {
        sendMessage(getApplication().getString(msgId),post);
    }

    /**
     * 发送消息，通过注册{@link BaseActivity#registerMessageEvent(MessageEvent.MessageObserver)}或
     * {@link BaseFragment#registerMessageEvent(MessageEvent.MessageObserver)} 或
     * {@link BaseDialogFragment#registerMessageEvent(MessageEvent.MessageObserver)}接收消息事件，
     * 也可通过观察{@link #getMessageEvent()}接收消息事件
     * @param message 消息内容
     */
    @MainThread
    public void sendMessage(String message){
        mMessageEvent.setValue(message);
    }

    /**
     * 发送消息，通过注册{@link BaseActivity#registerMessageEvent(MessageEvent.MessageObserver)}或
     * {@link BaseFragment#registerMessageEvent(MessageEvent.MessageObserver)} 或
     * {@link BaseDialogFragment#registerMessageEvent(MessageEvent.MessageObserver)}接收消息事件，
     * 也可通过观察{@link #getMessageEvent()}接收消息事件
     * @param message 消息内容
     * @param post 如果为{@code true}则可以在子线程调用，相当于调用{@link MutableLiveData#postValue(Object)}，
     *             如果为{@code false} 相当于调用{@link MutableLiveData#setValue(Object)}
     */
    public void sendMessage(String message,boolean post){
        if(post){
            mMessageEvent.postValue(message);
        }else{
            mMessageEvent.setValue(message);
        }
    }


    /**
     * 更新状态，通过注册{@link BaseActivity#registerStatusEvent(StatusEvent.StatusObserver)}或
     * {@link BaseFragment#registerStatusEvent(StatusEvent.StatusObserver)} 或
     * {@link BaseDialogFragment#registerStatusEvent(StatusEvent.StatusObserver)}接收消息事件，
     * 也可通过观察{@link #getStatusEvent()}接收消息事件
     * @param status
     */
    @MainThread
    public void updateStatus(@StatusEvent.Status int status){
        updateStatus(status,false);
    }

    /**
     * 更新状态，通过注册{@link BaseActivity#registerStatusEvent(StatusEvent.StatusObserver)}或
     * {@link BaseFragment#registerStatusEvent(StatusEvent.StatusObserver)} 或
     * {@link BaseDialogFragment#registerStatusEvent(StatusEvent.StatusObserver)}接收消息事件，
     * 也可通过观察{@link #getStatusEvent()}接收消息事件
     * @param status
     * @param post 如果为{@code true}则可以在子线程调用，相当于调用{@link MutableLiveData#postValue(Object)}，
     *             如果为{@code false} 相当于调用{@link MutableLiveData#setValue(Object)}
     */
    public void updateStatus(@StatusEvent.Status int status, boolean post){
        if(post){
            mStatusEvent.postValue(status);
        }else{
            mStatusEvent.setValue(status);
        }
    }

    /**
     * 发送单个消息事件，消息为{@link Message}对象，可通过{@link Message#what}区分消息类型，用法与{@link Message}一致，
     * 通过注册{@link BaseActivity#registerSingleLiveEvent(Observer)}或
     * {@link BaseFragment#registerSingleLiveEvent(Observer)} 或
     * {@link BaseDialogFragment#registerSingleLiveEvent(Observer)}接收消息事件，
     * 也可通过观察{@link #getSingleLiveEvent()}接收消息事件
     * @param what
     */
    @MainThread
    public void sendSingleLiveEvent(int what){
        sendSingleLiveEvent(what,false);
    }

    /**
     * 发送单个消息事件，消息为{@link Message}对象，可通过{@link Message#what}区分消息类型，用法与{@link Message}一致，
     * 通过注册{@link BaseActivity#registerSingleLiveEvent(Observer)}或
     * {@link BaseFragment#registerSingleLiveEvent(Observer)} 或
     * {@link BaseDialogFragment#registerSingleLiveEvent(Observer)}接收消息事件，
     * 也可通过观察{@link #getSingleLiveEvent()}接收消息事件
     * @param what
     * @param post 如果为{@code true}则可以在子线程调用，相当于调用{@link MutableLiveData#postValue(Object)}，
     *             如果为{@code false} 相当于调用{@link MutableLiveData#setValue(Object)}
     */
    public void sendSingleLiveEvent(int what, boolean post){
        Message message = Message.obtain();
        message.what = what;
        sendSingleLiveEvent(message,post);
    }

    /**
     * 发送单个消息事件，消息为{@link Message}对象，可通过{@link Message#what}区分消息类型，用法与{@link Message}一致，
     * 通过注册{@link BaseActivity#registerSingleLiveEvent(Observer)}或
     * {@link BaseFragment#registerSingleLiveEvent(Observer)} 或
     * {@link BaseDialogFragment#registerSingleLiveEvent(Observer)}接收消息事件，
     * 也可通过观察{@link #getSingleLiveEvent()}接收消息事件
     * @param message
     */
    @MainThread
    public void sendSingleLiveEvent(Message message){
        sendSingleLiveEvent(message,false);
    }

    /**
     * 发送单个消息事件，消息为{@link Message}对象，可通过{@link Message#what}区分消息类型，用法与{@link Message}一致，
     * 通过注册{@link BaseActivity#registerSingleLiveEvent(Observer)}或
     * {@link BaseFragment#registerSingleLiveEvent(Observer)} 或
     * {@link BaseDialogFragment#registerSingleLiveEvent(Observer)}接收消息事件，
     * 也可通过观察{@link #getSingleLiveEvent()}接收消息事件
     * @param message
     * @param post 如果为{@code true}则可以在子线程调用，相当于调用{@link MutableLiveData#postValue(Object)}，
     *             如果为{@code false} 相当于调用{@link MutableLiveData#setValue(Object)}
     */
    public void sendSingleLiveEvent(Message message, boolean post){
        if(post){
            mSingleLiveEvent.postValue(message);
        }else{
            mSingleLiveEvent.setValue(message);
        }
    }

    /**
     * 调用此类会同步通知执行{@link BaseActivity#showLoading()}或{@link BaseFragment#showLoading()}或
     * {@link BaseDialogFragment#showLoading()}
     */
    @MainThread
    public void showLoading() {
        showLoading(false);
    }

    /**
     * 调用此类会同步通知执行{@link BaseActivity#showLoading()}或{@link BaseFragment#showLoading()}或
     * {@link BaseDialogFragment#showLoading()}
     */
    public void showLoading(boolean post) {
        if(post){
            mLoadingEvent.postValue(true);
        }else{
            mLoadingEvent.setValue(true);
        }
    }

    /**
     * 调用此类会同步通知执行{@link BaseActivity#hideLoading()}或{@link BaseFragment#hideLoading()}或
     * {@link BaseDialogFragment#hideLoading()}
     */
    @MainThread
    public void hideLoading() {
        hideLoading(false);
    }


    /**
     * 调用此类会同步通知执行{@link BaseActivity#hideLoading()}或{@link BaseFragment#hideLoading()}或
     * {@link BaseDialogFragment#hideLoading()}
     * @param post 如果为{@code true}则可以在子线程调用，相当于调用{@link MutableLiveData#postValue(Object)}，
     *             如果为{@code false} 相当于调用{@link MutableLiveData#setValue(Object)}
     */
    public void hideLoading(boolean post) {
        if(post){
            mLoadingEvent.postValue(false);
        }else{
            mLoadingEvent.setValue(false);
        }
    }


}

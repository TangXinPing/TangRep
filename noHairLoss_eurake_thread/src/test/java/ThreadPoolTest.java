import com.hair.threadPool.DefaultThreadFactory;
import com.hair.threadPool.DefaultThreadPoolExecutor;
import com.hair.threadPool.WorkThread;

import java.util.concurrent.*;

public class ThreadPoolTest {


    public static void main(String args[]){
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        //创建一个指定了threadFactory的executor
        ThreadPoolExecutor threadPoolExecutor = threadPoolTest.createThreadExecutor();
        for (int i =0;i<10;i++){
            WorkThread workThread = new WorkThread();
            threadPoolExecutor.execute(workThread);
        }



    }

    public ThreadPoolExecutor createThreadExecutor(){
        DefaultThreadFactory defaultThreadFactory = new DefaultThreadFactory();
        ThreadPoolExecutor threadPoolExecutor
                = new DefaultThreadPoolExecutor(2,5,5,TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),defaultThreadFactory);
        return threadPoolExecutor;
    }
}

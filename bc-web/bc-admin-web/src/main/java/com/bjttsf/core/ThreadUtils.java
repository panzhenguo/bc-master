package com.bjttsf.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.Data;

@Data
public class ThreadUtils {
	private Integer maxThreadNum;
	ExecutorService fixedThreadPool =  new ThreadPoolExecutor(10, 100,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());
	
		
	
}

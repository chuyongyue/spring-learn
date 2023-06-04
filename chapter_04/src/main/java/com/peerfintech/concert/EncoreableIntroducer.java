package com.peerfintech.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @Description
 * @Author cy
 * @Date 2022/7/21 16:27
 **/
@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "com.peerfintech.concert.Performance", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}

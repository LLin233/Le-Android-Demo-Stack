package androidpath.ll.viewinjectdemo.lib;

/**
 * Created by Le on 2015/10/8.
 */
public enum RetentionPolicy {
    /**
     * Annotation is only available in the source code.
     */
    SOURCE,
    /**
     * Annotation is available in the source code and in the class file, but not
     * at runtime. This is the default policy.
     */
    CLASS,
    /**
     * Annotation is available in the source code, the class file and is
     * available at runtime.
     */
    RUNTIME
}
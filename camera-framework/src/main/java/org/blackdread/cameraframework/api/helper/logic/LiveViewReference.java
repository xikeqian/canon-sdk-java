package org.blackdread.cameraframework.api.helper.logic;

import org.blackdread.camerabinding.jna.EdsdkLibrary.EdsEvfImageRef;
import org.blackdread.camerabinding.jna.EdsdkLibrary.EdsStreamRef;
import org.blackdread.cameraframework.util.ReleaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;

/**
 * Stream and image ref of the live view.
 * * <br>
 * * Do not forget to <b>release both refs once not used</b> by calling close, best is to use <b>try-with-resource</b>.
 * <p>Created on 2018/11/03.</p>
 *
 * @author Yoann CAPLAIN
 */
public final class LiveViewReference implements Closeable {

    private static final Logger log = LoggerFactory.getLogger(LiveViewReference.class);

    private final EdsStreamRef.ByReference streamRef;

    private final EdsEvfImageRef.ByReference imageRef;

    public LiveViewReference(final EdsStreamRef.ByReference streamRef, final EdsEvfImageRef.ByReference imageRef) {
        this.streamRef = streamRef;
        this.imageRef = imageRef;
    }

    public EdsStreamRef.ByReference getStreamRef() {
        return streamRef;
    }

    public EdsEvfImageRef.ByReference getImageRef() {
        return imageRef;
    }

    @Override
    public void close() {
        try {
            ReleaseUtil.release(imageRef);
        } catch (Exception ex) {
            log.warn("Fail release (should never occur)", ex);
        }
        try {
            ReleaseUtil.release(streamRef);
        } catch (Exception ex) {
            log.warn("Fail release (should never occur)", ex);
        }
    }
}
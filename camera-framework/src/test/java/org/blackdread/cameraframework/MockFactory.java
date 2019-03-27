/*
 * MIT License
 *
 * Copyright (c) 2018-2019 Yoann CAPLAIN
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.blackdread.cameraframework;

import org.blackdread.cameraframework.api.helper.factory.CanonFactory;

/**
 * <p>Created on 2019/03/27.</p>
 *
 * @author Yoann CAPLAIN
 */
public interface MockFactory {

    /**
     * Initial factory that should be set back at end of test class to not impact next test classes
     */
    CanonFactory initialCanonFactory = CanonFactory.getCanonFactory();

    /**
     * To be called in method annotated with {@code org.junit.jupiter.api.AfterAll}
     */
    static void onTearDownClass() {
        CanonFactory.setCanonFactory(initialCanonFactory);
    }

    /**
     * To be called in method annotated with {@code org.junit.jupiter.api.BeforeEach}
     */
    default void setUpMock() {
        // TODO later can create all mocks for each element of CanonFactory
    }
}
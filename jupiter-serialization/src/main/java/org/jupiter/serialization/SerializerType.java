/*
 * Copyright (c) 2015 The Jupiter Project
 *
 * Licensed under the Apache License, version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jupiter.serialization;

/**
 * 抱歉在你想扩展序列化方式的时候还需要修改这个类
 *
 * jupiter
 * org.jupiter.serialization
 *
 * @author jiachun.fjc
 */
public enum SerializerType {
    PROTO_STUFF((byte) 0x01)
    ;

    SerializerType(byte value) {
        if (0x00 < value && value < 0x07) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("out of range(0x01 ~ 0x06): " + value);
        }
    }

    private final byte value;

    public byte value() {
        return value;
    }

    public static SerializerType parse(String name) {
        for (SerializerType s : values()) {
            if (s.name().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
}
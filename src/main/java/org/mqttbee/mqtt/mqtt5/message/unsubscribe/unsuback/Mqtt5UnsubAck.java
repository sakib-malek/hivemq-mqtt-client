/*
 * Copyright 2018 The MQTT Bee project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.mqttbee.mqtt.mqtt5.message.unsubscribe.unsuback;

import org.jetbrains.annotations.NotNull;
import org.mqttbee.annotations.DoNotImplement;
import org.mqttbee.annotations.Immutable;
import org.mqttbee.mqtt.datatypes.MqttUtf8String;
import org.mqttbee.mqtt.mqtt5.datatypes.Mqtt5UserProperties;
import org.mqttbee.mqtt.mqtt5.message.Mqtt5Message;
import org.mqttbee.mqtt.mqtt5.message.Mqtt5MessageType;

import java.util.List;
import java.util.Optional;

/**
 * MQTT 5 UNSUBACK packet.
 *
 * @author Silvio Giebl
 */
@DoNotImplement
public interface Mqtt5UnsubAck extends Mqtt5Message {

    /**
     * @return the reason codes of this UNSUBACK packet, each belonging to a topic filter in the corresponding
     *         UNSUBSCRIBE packet in the same order.
     */
    @Immutable @NotNull List<@NotNull Mqtt5UnsubAckReasonCode> getReasonCodes();

    /**
     * @return the optional reason string of this UNSUBACK packet.
     */
    @NotNull Optional<MqttUtf8String> getReasonString();

    /**
     * @return the optional user properties of this UNSUBACK packet.
     */
    @NotNull Mqtt5UserProperties getUserProperties();

    @Override
    default @NotNull Mqtt5MessageType getType() {
        return Mqtt5MessageType.UNSUBACK;
    }
}

package com.example.callback_vk.models.message_new;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ReplyMessage {

    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("from_id")
    @Expose
    private Integer fromId;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("attachments")
    @Expose
    private List<java.lang.Object> attachments;
    @SerializedName("reply_message")
    @Expose
    private ReplyMessage replyMessage;
    @SerializedName("conversation_message_id")
    @Expose
    private Integer conversationMessageId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("peer_id")
    @Expose
    private Integer peerId;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public ReplyMessage getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(ReplyMessage replyMessage) {
        this.replyMessage = replyMessage;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<java.lang.Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<java.lang.Object> attachments) {
        this.attachments = attachments;
    }

    public Integer getConversationMessageId() {
        return conversationMessageId;
    }

    public void setConversationMessageId(Integer conversationMessageId) {
        this.conversationMessageId = conversationMessageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public void setPeerId(Integer peerId) {
        this.peerId = peerId;
    }

}

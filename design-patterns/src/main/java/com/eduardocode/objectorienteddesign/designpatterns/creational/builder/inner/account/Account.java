package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.inner.account;

public class Account {

    private String userId;
    private String token;

    private Account() {
    }

    public String getUserId() {
        return userId;
    }

    private void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    private void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId='" + userId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public static Builder newBuilder() {
        return new Account().new Builder();
    }

    public class Builder {
        private Builder() {}

        public Builder setUserId(String userId) {
            Account.this.setUserId(userId);
            return this;
        }

        public Builder setToken(String token) {
            Account.this.setToken(token);
            return this;
        }

        public Account build() {
            return Account.this;
        }
    }
}

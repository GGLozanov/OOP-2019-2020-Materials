package com.lozanov;

public class Ownership {
    private String userId;
    private String gameId;
    private String boughtDate;

    public String getUserId() {
        return userId;
    }

    public String getGameId() {
        return gameId;
    }

    public String getBoughtDate() {
        return boughtDate;
    }

    public Ownership(String userId, String gameId, String boughtDate) {
        this.userId = userId;
        this.gameId = gameId;
        this.boughtDate = boughtDate;
    }
}

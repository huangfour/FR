package com.fr.pojo.bo;

/**
 * @author : hong.Four
 * @date : 2020-07-22 11:17
 **/
public class GroupStateBO {

    /**
     * groupName : group1
     * totalMB : 40188
     * freeMB : 32703
     * trunkFreeMB : 0
     * storageCount : 1
     * storagePort : 23000
     * storageHttpPort : 8888
     * activeCount : 1
     * currentWriteServer : 0
     * storePathCount : 1
     * subdirCountPerPath : 256
     * currentTrunkFileId : 0
     */

    private String groupName;
    private long totalMB;
    private long freeMB;
    private long trunkFreeMB;
    private int storageCount;
    private int storagePort;
    private int storageHttpPort;
    private int activeCount;
    private int currentWriteServer;
    private int storePathCount;
    private int subdirCountPerPath;
    private int currentTrunkFileId;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getTotalMB() {
        return totalMB;
    }

    public void setTotalMB(long totalMB) {
        this.totalMB = totalMB;
    }

    public long getFreeMB() {
        return freeMB;
    }

    public void setFreeMB(long freeMB) {
        this.freeMB = freeMB;
    }

    public long getTrunkFreeMB() {
        return trunkFreeMB;
    }

    public void setTrunkFreeMB(long trunkFreeMB) {
        this.trunkFreeMB = trunkFreeMB;
    }

    public int getStorageCount() {
        return storageCount;
    }

    public void setStorageCount(int storageCount) {
        this.storageCount = storageCount;
    }

    public int getStoragePort() {
        return storagePort;
    }

    public void setStoragePort(int storagePort) {
        this.storagePort = storagePort;
    }

    public int getStorageHttpPort() {
        return storageHttpPort;
    }

    public void setStorageHttpPort(int storageHttpPort) {
        this.storageHttpPort = storageHttpPort;
    }

    public int getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(int activeCount) {
        this.activeCount = activeCount;
    }

    public int getCurrentWriteServer() {
        return currentWriteServer;
    }

    public void setCurrentWriteServer(int currentWriteServer) {
        this.currentWriteServer = currentWriteServer;
    }

    public int getStorePathCount() {
        return storePathCount;
    }

    public void setStorePathCount(int storePathCount) {
        this.storePathCount = storePathCount;
    }

    public int getSubdirCountPerPath() {
        return subdirCountPerPath;
    }

    public void setSubdirCountPerPath(int subdirCountPerPath) {
        this.subdirCountPerPath = subdirCountPerPath;
    }

    public int getCurrentTrunkFileId() {
        return currentTrunkFileId;
    }

    public void setCurrentTrunkFileId(int currentTrunkFileId) {
        this.currentTrunkFileId = currentTrunkFileId;
    }
}

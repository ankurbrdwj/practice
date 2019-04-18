/**
 * 
 */
package com.ankur.sapient.entity;

/**
 * @author ankurbrdwj
 *
 */
public class Transaction {
	 private String clientId;
	 private String transactionId;
	 private String securityId;
	 private String transactionType;
	 private String marketValue;
	 private String transactinDate;
	 private String priorityflag;
	 private String processingFee;

	/**
	 * 
	 */
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}

	public String getTransactinDate() {
		return transactinDate;
	}

	public void setTransactinDate(String transactinDate) {
		this.transactinDate = transactinDate;
	}

	public String getPriorityflag() {
		return priorityflag;
	}

	public void setPriorityflag(String priorityflag) {
		this.priorityflag = priorityflag;
	}

	public String getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(String processingFee) {
		this.processingFee = processingFee;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((securityId == null) ? 0 : securityId.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Transaction)) {
			return false;
		}
		Transaction other = (Transaction) obj;
		if (clientId == null) {
			if (other.clientId != null) {
				return false;
			}
		} else if (!clientId.equals(other.clientId)) {
			return false;
		}
		if (securityId == null) {
			if (other.securityId != null) {
				return false;
			}
		} else if (!securityId.equals(other.securityId)) {
			return false;
		}
		if (transactionId == null) {
			if (other.transactionId != null) {
				return false;
			}
		} else if (!transactionId.equals(other.transactionId)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [clientId=" + clientId + ", transactionId=" + transactionId + ", securityId=" + securityId
				+ ", transactionType=" + transactionType + ", marketValue=" + marketValue + ", transactinDate="
				+ transactinDate + ", priorityflag=" + priorityflag + ", processingFee=" + processingFee + "]";
	}

}

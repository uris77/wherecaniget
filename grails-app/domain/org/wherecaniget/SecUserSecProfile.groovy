package org.wherecaniget

import org.apache.commons.lang.builder.HashCodeBuilder

class SecUserSecProfile implements Serializable {

	SecUser secUser
	SecProfile secProfile

	boolean equals(other) {
		if (!(other instanceof SecUserSecProfile)) {
			return false
		}

		other.secUser?.id == secUser?.id &&
			other.secProfile?.id == secProfile?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (secUser) builder.append(secUser.id)
		if (secProfile) builder.append(secProfile.id)
		builder.toHashCode()
	}

	static SecUserSecProfile get(long secUserId, long secProfileId) {
		find 'from SecUserSecProfile where secUser.id=:secUserId and secProfile.id=:secProfileId',
			[secUserId: secUserId, secProfileId: secProfileId]
	}

	static SecUserSecProfile create(SecUser secUser, SecProfile secProfile, boolean flush = false) {
		new SecUserSecProfile(secUser: secUser, secProfile: secProfile).save(flush: flush, insert: true)
	}

	static boolean remove(SecUser secUser, SecProfile secProfile, boolean flush = false) {
		SecUserSecProfile instance = SecUserSecProfile.findBySecUserAndSecProfile(secUser, secProfile)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(SecUser secUser) {
		executeUpdate 'DELETE FROM SecUserSecProfile WHERE secUser=:secUser', [secUser: secUser]
	}

	static void removeAll(SecProfile secProfile) {
		executeUpdate 'DELETE FROM SecUserSecProfile WHERE secProfile=:secProfile', [secProfile: secProfile]
	}

	static mapping = {
		id composite: ['secProfile', 'secUser']
		version false
	}
}

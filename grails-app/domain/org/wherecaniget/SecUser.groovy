package org.wherecaniget

class SecUser {

	transient springSecurityService

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, unique: true, email:true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<SecProfile> getAuthorities() {
		SecUserSecProfile.findAllBySecUser(this).collect { it.secProfile } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}

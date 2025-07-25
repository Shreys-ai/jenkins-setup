// jenkins/init.groovy.d/basic-config.groovy
import jenkins.model.*

Jenkins.instance.setNumExecutors(2)
Jenkins.instance.save()
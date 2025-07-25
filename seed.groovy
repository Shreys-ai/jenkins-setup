def jobFolder = new File("${JENKINS_HOME}/workspace/seed-job/jenkins/jobs")

jobFolder.eachFile { job ->
    if (job.name.endsWith(".groovy")) {
        evaluate job
    }
}

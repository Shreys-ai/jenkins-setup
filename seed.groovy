def jobFiles = new File("/var/jenkins_home/workspace/jenkins/jobs").listFiles()
jobFiles.each { job ->
    if (job.name.endsWith(".groovy")) {
        evaluate job
    }
}

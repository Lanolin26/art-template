package ru.lanolin.patternwriter.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.net.URL;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtifactoryTemplate {

    // Common
    private String name;
    //Create       = create
    //Update       = update
    private String templateType;
    private String key;
    // PackageTypes
    //	Generic   = generic
    //	Maven     = maven
    //	Gradle    = gradle
    //	Ivy       = ivy
    //	Sbt       = sbt
    //	Helm      = helm
    //	Cocoapods = cocoapods
    //	Opkg      = opkg
    //	Rpm       = rpm
    //	Nuget     = nuget
    //	Cran      = cran
    //	Gems      = gems
    //	Npm       = npm
    //	Bower     = bower
    //	Debian    = debian
    //	Composer  = composer
    //	Pypi      = pypi
    //	Docker    = docker
    //	Vagrant   = vagrant
    //	Gitlfs    = gitlfs
    //	Go        = go
    //	Yum       = yum
    //	Conan     = conan
    //	Chef      = chef
    //	Puppet    = puppet
    //	Vcs       = vcs
    //	Alpine    = alpine
    //	Conda     = conda
    //	P2        = p2
    private String packageType;
    private String description;
    private String notes;
    // Repo layout Refs
    //	BowerDefaultRepoLayout    = bower-default
    //	buildDefaultRepoLayout    = build-default
    //	ComposerDefaultRepoLayout = composer-default
    //	ConanDefaultRepoLayout    = conan-default
    //	GoDefaultRepoLayout       = go-default
    //	GradleDefaultRepoLayout   = maven-2-default
    //	IvyDefaultRepoLayout      = ivy-default
    //	Maven1DefaultRepoLayout   = maven-1-default
    //	Maven2DefaultRepoLayout   = maven-2-default
    //	NpmDefaultRepoLayout      = npm-default
    //	NugetDefaultRepoLayout    = nuget-default
    //	puppetDefaultRepoLayout   = puppet-default
    //	SbtDefaultRepoLayout      = sbt-default
    //	SimpleDefaultRepoLayout   = simple-default
    //	VcsDefaultRepoLayout      = vcs-default
    private String repoLayoutRef;
    private String mandatoryUrl;
    private String projectKey;
    // rclasses
    //	Local   = local
    //	Remote  = remote
    //	Virtual = virtual
    private String rclass;

    @JsonSerialize(using = PatternSerializer.class)
    @JsonDeserialize(using = PatternDeserializer.class)
    private Pattern excludesPattern;

    @JsonSerialize(using = PatternSerializer.class)
    @JsonDeserialize(using = PatternDeserializer.class)
    private Pattern includesPattern;

    // Mutual local and remote repository configuration
    private String handleReleases;
    private String handleSnapshots;
    private String maxUniqueSnapshots;
    private String suppressPomConsistencyChecks;
    private String blackedOut;
    private String xrayIndex;
    private String propertySets;
    private String downloadRedirect;
    private String blockPushingSchema1;

    // Mutual local and virtual repository configuration
    private String debianTrivialLayout;

    // Mutual remote and virtual repository configuration JSON keys
    private String externalDependenciesEnabled;
    private String externalDependenciesPatterns;

    // Unique local repository configuration JSON keys
    // Checksum Policies
    //	ClientChecksumPolicy           = client-checksums
    //	ServerGeneratedChecksumsPolicy = server-generated-checksums
    private String checksumPolicyType;
    private String maxUniqueTags;
    //
    // Snapshot version behaviors
    //	UniqueBehavior    = unique
    //	NonUniqueBehavior = non-unique
    //	DeployerBehavior  = deployer
    private String snapshotVersionBehavior;
    private String archiveBrowsingEnabled;
    private String calculateYumMetadata;
    private String yumRootDepth;
    // Docker api versions
    //	DockerApiV1 = V1
    //	DockerApiV2 = V2
    private String dockerApiVersion;
    private String enableFileListsIndexing;
    // Optional index compression formats
    //	Bz2Compression  = bz2
    //	LzmaCompression = lzma
    //	XzCompression   = xz
    private String optionalIndexCompressionFormats;
    private String forceNugetAuthentication;

    // Unique remote repository configuration JSON keys
    private URL url;
    private String username;
    private String password;
    private String proxy;
    // Remote repo checksum policies
    //	GenerateIfAbsentPolicy  = generate-if-absent
    //	FailPolicy              = fail
    //	IgnoreAndGeneratePolicy = ignore-and-generate
    //	PassThruPolicy          = pass-thru
    private String remoteRepoChecksumPolicyType;
    private String hardFail;
    private String offline;
    private String storeArtifactsLocally;
    private String socketTimeoutMillis;
    private String localAddress;
    private String retrievalCachePeriodSecs;
    private String failedRetrievalCachePeriodSecs;
    private String missedRetrievalCachePeriodSecs;
    private String unusedArtifactsCleanupEnabled;
    private String unusedArtifactsCleanupPeriodHours;
    private String assumedOfflinePeriodSecs;
    private String fetchJarsEagerly;
    private String fetchSourcesEagerly;
    private String rejectInvalidJars;
    private String shareConfiguration;
    private String synchronizeProperties;
    private String blockMismatchingMimeTypes;
    private String allowAnyHostAuth;
    private String enableCookieManagement;
    private String bowerRegistryUrl;
    private String composerRegistryUrl;
    private String pyPIRegistryUrl;
    // Vcs Types
    //	Git = GIT
    private String vcsType;
    // Vcs git provider
    //	GithubVcsProvider      = GITHUB
    //	BitbucketVcsProvider   = BITBUCKET
    //	OldstashVcsProvider    = OLDSTASH
    //	StashVcsProvider       = STASH
    //	ArtifactoryVcsProvider = ARTIFACTORY
    //	CustomVcsProvider      = CUSTOM
    private String vcsGitProvider;
    private String vcsGitDownloadUrl;
    private String bypassHeadRequests;
    private String clientTlsCertificate;
    private String feedContextPath;
    private String downloadContextPath;
    private String v3FeedUrl;
    private String contentSynchronisation;
    private String listRemoteFolderItems;
    private String enableTokenAuthentication;
    private String podsSpecsRepoUrl;

    // Unique virtual repository configuration JSON keys
    private String repositories;
    private String artifactoryRequestsCanRetrieveRemoteArtifacts;
    private String keyPair;
    // POM repository references cleanup policies
    //	DiscardActiveRefrencePolicy = discard_active_reference
    //	DiscardAnyReferencePolicy   = discard_any_reference
    //	NothingPolicy               = nothing
    private String pomRepositoryReferencesCleanupPolicy;
    private String defaultDeploymentRepo;
    private String forceMavenAuthentication;
    private String externalDependenciesRemoteRepo;

}

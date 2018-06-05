/**
 * 
 */

/*
 * Copyright (C) 2009 TopCoder Inc., All Rights Reserved.
 */
package com.cronos.onlinereview.phases.accuracytests;

import com.cronos.onlinereview.phases.AppealsPhaseHandler;

import com.topcoder.management.deliverable.Submission;
import com.topcoder.management.deliverable.Upload;
import com.topcoder.management.resource.Resource;
import com.topcoder.management.review.data.Review;
import com.topcoder.management.scorecard.data.Scorecard;

import com.topcoder.project.phases.Phase;
import com.topcoder.project.phases.PhaseStatus;
import com.topcoder.project.phases.Project;

import java.sql.Connection;


/**
 * Accuracy tests for V1.2 <code>AppealPhaseHandler</code>.
 *
 * @author assistant
 * @version 1.2
 */
public class AppealPhaseHandlerTestV12 extends BaseTestCase {
    /** Instance to test. */
    private AppealsPhaseHandler instance;

    /**
     * Sets up the environment.
     *
     * @throws java.lang.Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        instance = new AppealsPhaseHandler();
    }

    /**
     * Cleans up the environment.
     *
     * @throws java.lang.Exception to JUnit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test method for {@link com.cronos.onlinereview.phases.AppealPhaseHandler
     * #perform(com.topcoder.project.phases.Phase, java.lang.String)}.
     *
     * @throws Exception to JUnit
     */
    public void testPerform_1() throws Exception {
        Project project = setupProjectResourcesNotification("Appeals", true);
        Phase phase = project.getAllPhases()[4];

        Connection conn = getConnection();

        // create a registrant
        Resource resource = createResource(4, 101L, 1, 1);
        insertResources(conn, new Resource[] { resource });
        insertResourceInfo(conn, resource.getId(), 1, "4");
        insertResourceInfo(conn, resource.getId(), 2, "ACRush");
        insertResourceInfo(conn, resource.getId(), 4, "3808");
        insertResourceInfo(conn, resource.getId(), 5, "100");

        //insert the reviewers
        Resource reviewer = createResource(6, phase.getId(), 1, 4);
        super.insertResources(conn, new Resource[] { reviewer });
        insertResourceInfo(conn, reviewer.getId(), 1, "2");

        Resource reviewer2 = createResource(7, phase.getId(), 1, 4);
        super.insertResources(conn, new Resource[] { reviewer2 });
        insertResourceInfo(conn, reviewer2.getId(), 1, "3");

        // open submission
        phase.setPhaseStatus(PhaseStatus.OPEN);

        Upload upload = super.createUpload(1, project.getId(), resource.getId(), 1, 1, "Paramter");
        super.insertUploads(conn, new Upload[] { upload });

        Submission sub = super.createSubmission(1, upload.getId(), 1);
        super.insertSubmissions(conn, new Submission[] { sub });

        Scorecard sc = this.createScorecard(1, 1, 2, 1, "name", "1.0", 75.0f, 100.0f);
        Scorecard sc2 = this.createScorecard(3, 1, 2, 1, "name", "1.0", 75.0f, 100.0f);
        insertScorecards(conn, new Scorecard[] { sc, sc2 });

        Review review = createReview(1, reviewer.getId(), sub.getId(), sc.getId(), true, 77.0f);
        Review review2 = createReview(3, reviewer2.getId(), sub.getId(), sc2.getId(), true, 90.0f);
        insertReviews(conn, new Review[] { review, review2 });

        instance.perform(phase, "1001");

        // the subject should be Phase End: Online Review Phases
        // there should be one submission information in the email
        // manager/observer/reviewer should receive the email
        closeConnection();
    }

    /**
     * Test method for {@link com.cronos.onlinereview.phases.AppealPhaseHandler
     * #perform(com.topcoder.project.phases.Phase, java.lang.String)}.
     *
     * @throws Exception to JUnit
     */
    public void testPerform_2() throws Exception {
        Project project = setupProjectResourcesNotification("Appeals", true);
        Phase phase = project.getAllPhases()[4];

        Connection conn = getConnection();

        // create a registrant
        Resource resource = createResource(4, 101L, 1, 1);
        insertResources(conn, new Resource[] { resource });
        insertResourceInfo(conn, resource.getId(), 1, "4");
        insertResourceInfo(conn, resource.getId(), 2, "ACRush");
        insertResourceInfo(conn, resource.getId(), 4, "3808");
        insertResourceInfo(conn, resource.getId(), 5, "100");

        //insert the reviewers
        Resource reviewer = createResource(6, phase.getId(), 1, 4);
        super.insertResources(conn, new Resource[] { reviewer });
        insertResourceInfo(conn, reviewer.getId(), 1, "2");

        Resource reviewer2 = createResource(7, phase.getId(), 1, 4);
        super.insertResources(conn, new Resource[] { reviewer2 });
        insertResourceInfo(conn, reviewer2.getId(), 1, "3");

        // open submission
        phase.setPhaseStatus(PhaseStatus.SCHEDULED);

        Upload upload = super.createUpload(1, project.getId(), resource.getId(), 1, 1, "Paramter");
        super.insertUploads(conn, new Upload[] { upload });

        Submission sub = super.createSubmission(1, upload.getId(), 1);
        super.insertSubmissions(conn, new Submission[] { sub });

        Scorecard sc = this.createScorecard(1, 1, 2, 1, "name", "1.0", 75.0f, 100.0f);
        Scorecard sc2 = this.createScorecard(3, 1, 2, 1, "name", "1.0", 75.0f, 100.0f);
        insertScorecards(conn, new Scorecard[] { sc, sc2 });

        Review review = createReview(1, reviewer.getId(), sub.getId(), sc.getId(), true, 77.0f);
        Review review2 = createReview(3, reviewer2.getId(), sub.getId(), sc2.getId(), true, 90.0f);
        insertReviews(conn, new Review[] { review, review2 });

        instance.perform(phase, "1001");

        // the subject should be Phase End: Online Review Phases
        // there should be one submission information in the email
        // manager/observer/reviewer should receive the email
        closeConnection();
    }
}

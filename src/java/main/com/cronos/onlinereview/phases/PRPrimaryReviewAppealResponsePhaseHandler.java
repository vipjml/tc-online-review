/**
 * Copyright (C) 2011 TopCoder Inc., All Rights Reserved.
 */
package com.cronos.onlinereview.phases;

import com.topcoder.management.phase.PhaseHandlingException;
import com.topcoder.project.phases.Phase;

/**
 * <p>
 * The extend from <code>PrimaryReviewAppealsResponsePhaseHandler</code> to add on the logic to push data to
 * project_result.
 * </p>
 * 
 * @author TCSASSEMBER
 * @version 1.0
 */
public class PRPrimaryReviewAppealResponsePhaseHandler extends PrimaryReviewAppealsResponsePhaseHandler {

    /**
     * Used for pulling data to project_result table and filling payments.
     */
     private PRHelper prHelper = new PRHelper();
     
    /**
     * winners email template name
     */
    private String winnersEmailTemplateName;

    /**
     * subject for the winners email
     */
    private String winnersEmailSubject;

    /**
     * sender address of the winners email
     */
    private String winnersEmailFromAddress;

    /**
     * Create a new instance of <code>PRPrimaryReviewAppealResponsePhaseHandler</code> using the default namespace for
     * loading configuration settings.
     * 
     * @throws ConfigurationException
     *             if errors occurred while loading configuration settings.
     */
    public PRPrimaryReviewAppealResponsePhaseHandler() throws ConfigurationException {
        this(DEFAULT_NAMESPACE);
    }

    /**
     * Create a new instance of <code>PRPrimaryReviewAppealResponsePhaseHandler</code> using the given namespace for
     * loading configuration settings.
     * 
     * @param namespace
     *            the namespace to load configuration settings from.
     * @throws ConfigurationException
     *             if errors occurred while loading configuration settings or required properties missing.
     * @throws IllegalArgumentException
     *             if the input is null or empty string.
     */
    public PRPrimaryReviewAppealResponsePhaseHandler(String namespace) throws ConfigurationException {
        super(namespace);
        this.winnersEmailTemplateName = PhasesHelper
                .getPropertyValue(namespace, "WinnersEmail.EmailTemplateName", true);
        this.winnersEmailSubject = PhasesHelper.getPropertyValue(namespace, "WinnersEmail.EmailSubject", true);
        this.winnersEmailFromAddress = PhasesHelper.getPropertyValue(namespace, "WinnersEmail.EmailFromAddress", true);
    }

    /**
     * Provides additional logic to execute a phase. this exetension will update valid_submission_ind, submit_timestamp
     * field of project_result table.</p>
     * 
     * @param phase
     *            The input phase to check.
     * @param operator
     *            The operator that execute the phase.
     * 
     * @throws PhaseNotSupportedException
     *             if the input phase type is not "Submission" type.
     * @throws PhaseHandlingException
     *             if there is any error occurred while processing the phase.
     * @throws IllegalArgumentException
     *             if the input parameters is null or empty string.
     */
    public void perform(Phase phase, String operator) throws PhaseHandlingException { 
        super.perform(phase, operator);
        long projectId = phase.getProject().getId();
        boolean toStart = PhasesHelper.checkPhaseStatus(phase.getPhaseStatus());
        // Only will perform while submission phase is ended
        try {
            prHelper.processAppealResponsePR(projectId, toStart);
            // send winner email as appropriate here
            if (!toStart) {
                PRHelper.sendMailForWinners(getManagerHelper(),
                        getManagerHelper().getProjectManager().getProject(projectId), winnersEmailSubject,
                        winnersEmailFromAddress, winnersEmailTemplateName);
            }
        } catch (Throwable e) {
            throw new PhaseHandlingException(e.getMessage(), e);
        }
    }
}
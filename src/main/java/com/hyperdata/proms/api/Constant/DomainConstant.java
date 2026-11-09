package com.hyperdata.proms.api.Constant;

/**
 * Nilai enum-like yang dipakai kolom text + CHECK constraint di database.
 * Disimpan sebagai String (bukan enum Java) agar persis sama dengan nilai di DB.
 */
public final class DomainConstant {
    private DomainConstant() {}

    public static final class TenantStatus {
        private TenantStatus() {}
        public static final String TRIAL = "trial";
        public static final String ACTIVE = "active";
        public static final String PAST_DUE = "past_due";
        public static final String READ_ONLY = "read_only";
        public static final String SUSPENDED = "suspended";
        public static final String CANCELLED = "cancelled";
    }

    /** platform.tenant_members.role */
    public static final class WorkspaceRole {
        private WorkspaceRole() {}
        public static final String OWNER = "owner";
        public static final String ADMIN = "admin";
        public static final String FINANCE = "finance";
        public static final String MEMBER = "member";
        public static final String GUEST = "guest";
    }

    /** platform.tenant_members.status */
    public static final class MemberStatus {
        private MemberStatus() {}
        public static final String ACTIVE = "active";
        public static final String DEACTIVATED = "deactivated";
    }

    /** proms.boards.status */
    public static final class BoardStatus {
        private BoardStatus() {}
        public static final String ACTIVE = "active";
        public static final String FINISHED = "finished";
        public static final String ARCHIVED = "archived";
    }

    /** proms.board_members.role */
    public static final class BoardRole {
        private BoardRole() {}
        public static final String ADMIN = "admin";
        public static final String PM = "pm";
        public static final String MEMBER = "member";
        public static final String VIEWER = "viewer";
        public static final String GUEST = "guest";
    }

    /** proms.board_columns.category */
    public static final class ColumnCategory {
        private ColumnCategory() {}
        public static final String NOT_STARTED = "not_started";
        public static final String IN_PROGRESS = "in_progress";
        public static final String BLOCKED = "blocked";
        public static final String DONE = "done";
    }

    /** proms.milestones.status */
    public static final class MilestoneStatus {
        private MilestoneStatus() {}
        public static final String OPEN = "open";
        public static final String COMPLETED = "completed";
    }

    /** proms.boards.health / proms.milestones.health */
    public static final class Health {
        private Health() {}
        public static final String NO_TASKS = "no_tasks";      // hanya milestone
        public static final String ON_TRACK = "on_track";
        public static final String AT_RISK = "at_risk";
        public static final String OFF_TRACK = "off_track";
        public static final String NEEDS_REVIEW = "needs_review"; // hanya board
        public static final String DONE = "done";
    }
}
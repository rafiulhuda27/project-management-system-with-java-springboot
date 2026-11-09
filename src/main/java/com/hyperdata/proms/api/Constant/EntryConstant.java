package com.hyperdata.proms.api.Constant;

public class EntryConstant {
    private  EntryConstant() {

    }

    public final static String BASE = AuthenticationConstant.API + AuthenticationConstant.VERSION;
    public final static String ME = BASE + "me";
    public final static String ME_PROFILE = BASE + "me/profile";
    public final static String ME_NOTIFCATION_SETTINGS = BASE + "me/notification-settings";
    public final static String SEARCH = BASE + "search";

    // ===================== BOARDS =====================
    public static final String BOARDS = BASE + "boards";                                  // GET, POST
    public static final String BOARD_BY_ID = BOARDS + "/{boardId}";                       // GET, PATCH, DELETE
    public static final String BOARD_ARCHIVE = BOARD_BY_ID + "/archive";
    public static final String BOARD_RESTORE = BOARD_BY_ID + "/restore";
    public static final String BOARD_SHARING = BOARD_BY_ID + "/sharing";                  // PATCH
    public static final String BOARD_MEMBERS = BOARD_BY_ID + "/members";                  // POST
    public static final String BOARD_TEAMS = BOARD_BY_ID + "/teams";                      // POST
    public static final String BOARD_LEAVE = BOARD_BY_ID + "/leave";
    public static final String DIRECTORY_TEAMS = BASE + "directory/teams";
    public static final String DIRECTORY_MEMBERS = BASE + "directory/members";

    // Board groups
    public static final String BOARD_GROUPS = BASE + "board-groups";                      // GET, POST, DELETE
    public static final String BOARD_GROUPS_RENAME = BOARD_GROUPS + "/rename";            // PATCH
    public static final String BOARD_GROUP_BY_ID = BOARD_GROUPS + "/{groupId}";           // PATCH, DELETE

    // Saved views
    public static final String BOARD_VIEWS = BOARD_BY_ID + "/views";                      // GET, POST
    public static final String BOARD_VIEW_BY_ID = BOARD_VIEWS + "/{viewId}";              // PATCH, DELETE

    // Workstreams
    public static final String BOARD_WORKSTREAMS = BOARD_BY_ID + "/workstreams";          // GET, POST
    public static final String WORKSTREAMS = BASE + "workstreams";
    public static final String WORKSTREAM_BY_ID = WORKSTREAMS + "/{workstreamId}";        // PATCH, DELETE

    // Columns
    public static final String BOARD_COLUMNS = BOARD_BY_ID + "/columns";                  // GET, POST
    public static final String BOARD_COLUMNS_REORDER = BOARD_COLUMNS + "/reorder";        // POST
    public static final String COLUMNS = BASE + "columns";
    public static final String COLUMN_BY_ID = COLUMNS + "/{columnId}";                    // PATCH, DELETE

    // Milestones
    public static final String BOARD_MILESTONES = BOARD_BY_ID + "/milestones";            // GET, POST
    public static final String MILESTONES = BASE + "milestones";
    public static final String MILESTONE_BY_ID = MILESTONES + "/{milestoneId}";           // PATCH, DELETE

    // ===================== MINUTES OF MEETING =====================
    public static final String BOARD_MOMS = BOARD_BY_ID + "/moms";                        // GET, POST
    public static final String BOARD_MOM_BY_ID = BOARD_MOMS + "/{momId}";                 // GET, PATCH, DELETE
    public static final String MOM_CONVERT_TO_TASK =
            BOARD_MOM_BY_ID + "/action-items/{actionItemId}/convert-to-task";             // POST
    public static final String MOM_EXPORT_PDF = BOARD_MOM_BY_ID + "/export-pdf";          // GET, POST
    public static final String MOM_RENDER_PDF = BOARD_MOMS + "/render-pdf";               // GET, POST

    // ===================== TASKS =====================
    public static final String MY_TASKS = BASE + "my-tasks";
    public static final String BOARD_TASKS = BOARD_BY_ID + "/tasks";                      // POST
    public static final String TASKS = BASE + "tasks";
    public static final String TASK_BY_ID = TASKS + "/{taskId}";                          // GET, PATCH, DELETE
    public static final String TASK_MOVE = TASK_BY_ID + "/move";                          // PATCH
    public static final String TASK_ACTIVITIES = TASK_BY_ID + "/activities";

    // Task dependencies
    public static final String TASK_DEPENDENCIES = TASK_BY_ID + "/dependencies";          // GET, POST
    public static final String TASK_DEPENDENCY_BY_TARGET =
            TASK_DEPENDENCIES + "/{targetTaskId}";                                        // DELETE

    // Comments
    public static final String TASK_COMMENTS = TASK_BY_ID + "/comments";                  // GET, POST
    public static final String TASK_COMMENT_BY_ID = TASK_COMMENTS + "/{commentId}";       // PATCH, DELETE

    // Attachments
    public static final String BOARD_ATTACHMENTS = BOARD_BY_ID + "/attachments";          // GET
    public static final String TASK_ATTACHMENTS = TASK_BY_ID + "/attachments";            // GET, POST
    public static final String ATTACHMENTS = BASE + "attachments";
    public static final String ATTACHMENT_DOWNLOAD = ATTACHMENTS + "/{attachmentId}/download"; // GET
    public static final String ATTACHMENT_BY_ID = ATTACHMENTS + "/{attachmentId}";        // DELETE

    // Task feedback (poin)
    public static final String TASK_FEEDBACK = TASK_BY_ID + "/feedback";                  // GET, PUT

    // ===================== DASHBOARD =====================
    public static final String DASHBOARD_REMINDERS = BASE + "dashboard/reminders";        // GET, POST
    public static final String DASHBOARD_REMINDER_BY_ID = DASHBOARD_REMINDERS + "/{reminderId}"; // PATCH, DELETE
    public static final String DASHBOARD_TEAM_ACTIVITY = BASE + "dashboard/team-activity";

    // ===================== AUTOMATION =====================
    public static final String BOARD_AUTOMATIONS = BOARD_BY_ID + "/automations";          // GET, POST
    public static final String BOARD_AUTOMATION_BY_ID = BOARD_AUTOMATIONS + "/{ruleId}";  // PATCH, DELETE

    // ===================== INBOX =====================
    public static final String INBOX = BASE + "inbox";                                    // GET
    public static final String INBOX_READ_ALL = INBOX + "/read-all";                      // POST
    public static final String INBOX_BY_ID = INBOX + "/{inboxId}";                        // DELETE (archive)
    public static final String INBOX_READ = INBOX_BY_ID + "/read";                        // POST
    public static final String INBOX_UNREAD = INBOX_BY_ID + "/unread";                    // POST
    public static final String INBOX_SNOOZE = INBOX_BY_ID + "/snooze";                    // POST
    public static final String INBOX_UNSNOOZE = INBOX_BY_ID + "/unsnooze";                // POST
    public static final String INBOX_DECISION = INBOX_BY_ID + "/decision";                // POST

    // ===================== WORKSPACE =====================
    public static final String WORKSPACE_MEMBERS = BASE + "workspace/members";            // GET, POST
    public static final String WORKSPACE_MEMBER_BY_ID = WORKSPACE_MEMBERS + "/{memberId}"; // PATCH, DELETE
    public static final String WORKSPACE_OWNERSHIP_TRANSFER = BASE + "workspace/ownership-transfer"; // POST

    public static final String WORKSPACE_CALENDAR = BASE + "workspace/calendar";          // GET, PUT
    public static final String WORKSPACE_HOLIDAYS = BASE + "workspace/holidays";          // GET, POST
    public static final String WORKSPACE_HOLIDAY_BY_ID = WORKSPACE_HOLIDAYS + "/{holidayId}"; // DELETE

    // Master lokasi & kelompok anggota (dipakai bersama oleh dua resource)
    public static final String WORKSPACE_LOCATIONS = BASE + "workspace/locations";        // GET, POST
    public static final String WORKSPACE_MEMBER_GROUPS = BASE + "workspace/member-groups"; // GET, POST
    public static final String PLACEMENT_REORDER = "/reorder";                            // POST  (tambahkan ke dua konstanta di atas)
    public static final String PLACEMENT_BY_ID = "/{placementId}";                        // PATCH, DELETE (tambahkan ke dua konstanta di atas)

    // ===================== TEAMS =====================
    public static final String TEAMS = BASE + "teams";                                    // GET, POST
    public static final String TEAM_BY_ID = TEAMS + "/{teamId}";                          // GET, PATCH
    public static final String TEAM_STATUS = TEAM_BY_ID + "/status";                      // POST
    public static final String TEAM_MEMBERS = TEAM_BY_ID + "/members";                    // POST
    public static final String TEAM_MEMBER_BY_ID = TEAM_MEMBERS + "/{userId}";            // PATCH (lead), DELETE

    // ===================== POINTS =====================
    public static final String POINTS_POLICY = BASE + "points/policy";                    // GET, PUT
    public static final String POINTS_LEADERBOARD = BASE + "points/leaderboard";
    public static final String POINTS_ENTRIES = BASE + "points/entries";
    public static final String ME_POINTS = BASE + "me/points";

    // ===================== STAND-UP =====================
    public static final String ME_STANDUP_TODAY = BASE + "me/standup/today";
    public static final String ME_STANDUPS = BASE + "me/standups";                        // GET, POST
    public static final String ME_STANDUP_BY_ID = ME_STANDUPS + "/{standupId}";           // PATCH
    public static final String STANDUPS = BASE + "standups";
    public static final String STANDUPS_COMPLIANCE = STANDUPS + "/compliance";
    public static final String WORKSPACE_STANDUP_POLICY = BASE + "workspace/standup-policy"; // GET, PUT

    // ===================== FOCUS SESSIONS =====================
    public static final String FOCUS_SESSIONS = BASE + "focus-sessions";                  // GET, POST
    public static final String FOCUS_SESSION_BY_ID = FOCUS_SESSIONS + "/{sessionId}";     // DELETE

    // ===================== CHAT =====================
    public static final String BOARD_CHAT = BOARD_BY_ID + "/chat";
    public static final String CHAT_CHANNELS = BOARD_CHAT + "/channels";                  // GET, POST
    public static final String CHAT_CHANNEL_MESSAGES = CHAT_CHANNELS + "/{channelId}/messages"; // GET, POST
    public static final String CHAT_CHANNEL_READ = CHAT_CHANNELS + "/{channelId}/read";   // POST
    public static final String CHAT_MESSAGE_BY_ID = BOARD_CHAT + "/messages/{messageId}"; // PUT/PATCH, DELETE
    public static final String CHAT_MESSAGE_PIN = CHAT_MESSAGE_BY_ID + "/pin";            // POST
    public static final String CHAT_MESSAGE_REACT = CHAT_MESSAGE_BY_ID + "/react";        // POST
    public static final String CHAT_MESSAGE_CONVERT_TASK = CHAT_MESSAGE_BY_ID + "/convert-task"; // POST

    // ===================== WEB PUSH =====================
    public static final String PUSH_VAPID_PUBLIC_KEY = BASE + "push/vapid-public-key";
    public static final String PUSH_SUBSCRIPTIONS = BASE + "push/subscriptions";          // POST, DELETE
    public static final String PUSH_PRESENCE = BASE + "push/presence";   
}

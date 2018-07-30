$( document ).ready(function() {

    $("#getSchedule").click(function(){
        var count = $("#teamCount").val();
        if(count <=1){
            alert($.i18n.prop('count_alert'))
        }else{
            $.ajax({
                method: "POST",
                url: "/tournament",
                data : {
                    teamCount : count,
                    startDate: new Date()
                }
            }).done(function(tournament){
                displaySchedule(tournament);
            })
        }

    });

    $("#lang").change(function(){
        updateLanguage($(this).val());
    })

    function updateLanguage(lang){
        $.i18n.properties({
            name: 'Messages',
            path: 'js/lib/bundle/',
            mode: 'both',
            language: lang,
            callback: function() {
                $("#homeTeam").html($.i18n.prop('home_team'));
                $("#awayTeam").html($.i18n.prop('away_team'));
                $("#day").html($.i18n.prop('day'));
                $("#getSchedule").html($.i18n.prop('get_schedule'));
                $("#teamCountLabel").html($.i18n.prop('team_count'));
                $("#languageLabel").html($.i18n.prop('language'));
                $("#home").html($.i18n.prop('home'));
                $("#tournaments").html($.i18n.prop('tournaments'));
            }
        })
    }
    updateLanguage("english");

    function displaySchedule(tournament){
        $("#tableBody").empty();
        $.each(tournament.events,function(i,event){
            $("#tableBody").append(getTableRow(event));
        })
    }

    function getTableRow(event){
        return "<tr><td> Team-"+event.firstTeam+"</td><td>Team-"+event.secondTeam+"</td><td>"+event.day+"</td></tr>";
    }
});
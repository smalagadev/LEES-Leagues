export class Tweet {
    created_at: string;
    text: string;
    user:{
        name: string;
        screen_name: string;
        url: string;
        description: string;
    };
    place: string;
    entities:{
        hashtags: string;
        urls:{
            url: string;
            title: string;
        };
        user_mentions: string;
    };
}

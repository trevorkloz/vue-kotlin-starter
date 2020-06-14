<template>
    <div class="subcomponent">
        <span>Download repository here:
            <a target="_blank" :href="getLink()">{{githublink}}</a></span>
    </div>
</template>

<script>

    export default {
        name: 'SubComponent',
        props: {
            githublink: {
                type: String,
                required: true
            }
        },
        data() {
            return {
                href: this.githublink
            }
        },
        methods: {
            getLink() {
                return "https://github.com/" + this.githublink;
            }
        }
    }
</script>

<style scoped lang="scss">
    $active-color: #f3d23e;

    .subcomponent {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        font-size: 16px;
        color: #a7a8a8;
    }

</style>
